package arrayList;

import java.util.*;

/**
 * 该类为源代码摘抄类，具体请见"java.util.ArrayList"
 *
 * 因为ArrayList都是基于数组实现的，所以支持快速随机访问
 * 即"RandomAccess"接口标识了该类支持快速随机访问
 *
 * @param <E>
 */
public class ArrayList_code<E> extends AbstractList<E>
        implements List<E>, RandomAccess/* 快速随机访问标识接口 */, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = 8683452581122892189L;

    /**
     * DEFAULT CAPACITY 翻译为"默认容量"
     *
     * ArrayList的内部实现的数组默认长度为10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * EMPTY_ELEMENTDATA 翻译为"空元素数据"
     *
     * 指定数组的容量为0的时候使用这个变量赋值
     *
     * 通过元数组可得出 ArrayList 的内部实现是一个 Object 类型静态的、final 的空数组；
     *
     * 用于空实例共享空数组实例
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * DEFAULTCAPACITY_EMPTY_ELEMENTDATA 翻译为"默认长度空元素数据"
     *
     * 默认的实例化的时候使用此变量赋值
     *
     * 用于默认大小的空实例共享空数组实例。
     * 将此与EMPTY_ELEMENTDATA区分开来，以便在添加第一个元素时知道要扩展多少。
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 此属性是 ArrayList 真正存放对象数组的属性
     *
     * 存储ArrayList元素的数组缓冲区。
     * ArrayList的容量是此数组缓冲区的长度。
     * 添加第一个元素时，任何带有elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDAT 的空ArrayList都将扩展为DEFAULT_CAPACITY。
     *
     *  注意：该变量是非私有的，它将用于类嵌套使用
     *
     * 用transient关键字标记的成员变量不参与序列化过程
     */
    transient Object[] elementData;

    /**
     * 构造具有指定初始容量的空列表
     *
     * @param initialCapacity 数组的初始长度
     * @throws IllegalAccessException 非法访问异常
     */
    public ArrayList_code(int initialCapacity) throws IllegalAccessException {
        if (initialCapacity > 0) {
            // 如果大于0，就将 elementData 初始化为一个容量为 initialCapacity 的对象数组
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            // 如果等于0，则将其设置为默认大小
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            // 如果用户构造方法中输入 initialCapacity < 0 则会抛出该"非法访问异常"并提示该访问方式是错误的
            throw new IllegalAccessException("Illegal Capacity:" + initialCapacity);
        }
    }

    /**
     * 无参构造方法
     */
    public ArrayList_code() {
        // 其元数组长度为默认值，
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 构造一个包含指定集合的元素的列表，按照它们由集合的迭代器返回的顺序
     *
     * 用于传入任意的集合，并使其转化为 ArrayList 集合
     *
     * @param c
     */
    public ArrayList_code(Collection<? extends E> c) {
        // 将该集合通过 toArray() 方法返回数组的形式并赋值给 elementData 的缓冲区
        elementData = c.toArray();
        // 判断该数组长度是否等于0
        if ((size = elementData.length) != 0) {
            // 防止c.toArray（错误地）不返回Object []
            if (elementData.getClass() != Object[].class)
                // 使用 copyOf() 方法 copy 到元数组，最后一个参数为运行时类的副本已保证数组元素的正确性
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            // 如果不为0则返回元数组
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * ArrayList 数组长度的成员变量
     */
    private int size;

    /**
     * 该属性来源于继承父类 AbstractList
     *
     * modCount 即集合结构被操作了多少次
     *
     * 该属性用于记录集合被操作(增删改查)了多少次
     */
    protected transient int modCount = 0;

    /**
     * 调整 ArrayList 的长度为当前缓存区的长度
     */
    public void trimToSize() {
        // 记录数+1
        modCount ++;
        // 如果长度 size 小于缓存数组长度 elementData
        if (size < elementData.length) {
            // 元数组长度使其为0 ？缓存数组 : 一个新的以当前长度大小的数组
            elementData = (size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyOf(elementData, size);
        }
    }

    /**
     * 主动设置 ArrayList 的容量
     *
     * @param minCapacity 需要设置的值
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length
                && !(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
                    && minCapacity <= DEFAULT_CAPACITY)) {
                modCount ++;
                // 调用增长方法
                grow(minCapacity);
        }
    }

    /**
     * 要分配的数组的大小
     *
     * 这个常量用于表示 ArrayList 可以扩容的最大长度
     *
     * 值为 Integer 的 Max_VALUE 的常量，即0x7fffffff，这个是 int 类型的最大值
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 数组的增长方法
     *
     * @param minCapacity 设置容量长度 int 值
     * @return 以参数 minCapacity 长度的新数组
     */
    private Object[] grow(int minCapacity) {
        // 新的数组还会去调用 newCapacity() 方法来判断返回的长度大小
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
    }

    /**
     * 新的数组容量的长度
     *
     * @param minCapacity 设置容量长度的 int 值
     * @return 新数组的长度
     */
    private int newCapacity(int minCapacity) {
        // 原数组长度
        int oldCapacity = elementData.length;
        // 新数组为原数组长度的1.5倍， >> 1 的结果为1.5
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 如果新数组长度和设定的数组长度小于等于0
        if (newCapacity - minCapacity <= 0) {
            // 如果此时缓存数组是默认容量的数组
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                // 返回默认数组与参数值的之间的最大值，Math.max()方法将比较两者之间的大小
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            } else if (minCapacity < 0) {
                // 如果参数为错误值，则返回"内存溢出"异常
                throw new OutOfMemoryError();
            } else {
                // 返回参数值
                return minCapacity;
            }
        }
            return (newCapacity - MAX_ARRAY_SIZE <= 0) ? newCapacity : hugeCapacity(minCapacity);
        }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }


    @Override
    public E get(int index) {
        return null;
    }

    /**
     * 返回 ArrayList 的长度
     *
     * @return 返回 size 成员属性
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 判断 ArrayList 是否为空
     *
     * @return 判断 size 值是否为0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断 ArrayList 是否包含指定元素
     *
     * @param o 传入的对象参数
     * @return 返回 boolean 值是否存在
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * 返回指定对象的第一次出现的索引
     *
     * @param o 传入的对象
     * @return 第一次出现的 int 索引值
     */
    public int indexOf(Object o) {
        return indexOfRange(o, 0, size);
    }

    /**
     * 内部调用的方法
     *
     * @param o 传入的对象
     * @param start 数组的起始值
     * @param end 数组的最后值
     * @return 第一次出现的 int 索引值
     */
    int indexOfRange(Object o, int start, int end) {
        // 将缓存数组赋值给临时对象数组 es
        Object[] es = elementData;
        // 如果要寻找数组中为 null 的值则会返回第一次出现 null 的索引值
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                // equals()方法对应的值，返回其索引
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        // 未找着，返回-1
        return -1;
    }

    /**
     * 返回传入的对象在 ArrayList 最后一次出现的索引
     *
     * @param o 传入的对象
     * @return 最后一次出现的 int 的索引值
     */
    public int lastIndexOf(Object o) {
        return lastIndexOfRange(o, 0, size);
    }

    /**
     * 内部实现与上述一致，不过是for循环反向循环
     *
     * @param o 传入的对象
     * @param start 起始值
     * @param end 最后值
     * @return 返回最后一次出现的 int 的索引值
     */
    int lastIndexOfRange(Object o, int start, int end) {
        Object[] es = elementData;
        if (o == null) {
            for (int i = end - 1; i >= start; i--) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = end - 1; i >= start; i--) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * ArrayList实例的浅拷贝方法
     *
     * @return 返回这个 ArrayList 实例的克隆
     */
    public Object clone() {
        // TODO
        return elementData;
    }

    /**
     * 将 ArrayList 转化为数组
     *
     * 以顺序的顺序（从第一个元素到最后一个元素）返回包含此 ArrayList 中所有元素的数组
     *
     * @return 以 ArrayList 为数组元素的数组
     */
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * 将 ArrayList 转化为数组
     *
     * 以顺序的顺序（从第一个元素到最后一个元素）返回包含此 ArrayList 中所有元素的数组
     *
     * @param a 要存储列表的元素的数组，如果它够大; 否则，为此目的分配相同运行时类型的新数组
     * @param <T> 包含集合的数组的运行时类型
     * @return 返回的数组的运行时类型是指定数组的运行时类型
     */
    public <T> T[] toArray(T[] a) {
        // TODO
        return a;
    }

    // ArrayList 访问操作

    E elementData(int index) {
        return (E) elementData[index];
    }

    static <E> E elementAt(Object[] es, int index) {
        return (E) es[index];
    }

    /**
     * ArrayList 的增加元素的方法
     *
     * 在该方法中增长数组的两个方法以保证容量足够，如果不够会使用 grow() 进行增容
     * 所以调用扩容的操作及其消耗资源，效率极低
     *
     * 所以建议最好创建 ArrayList 对象时大概的指定大小，减少扩容次数
     *
     * @param e 传入一个对应类型对象的变量
     * @return 返回 true 表示该方法执行完成
     */
    public boolean add(E e) {
        // 调用了增加数组长度的方法，使其长度+1
        ensureCapacity(size + 1);
        // 缓存区数组长度++
        elementData[size++] = e;
        // 执行到此处返回 true 说明方法执行完成
        return true;
    }

    /**
     *
     *
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    /**
     * ArrayList 的删除元素的方法
     */
    public E remove(int index) {
        // 检查index是否在list的容量大小范围之内，否则抛出异常
        rangCheck(index);
        modCount++;
        E oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        }
        elementData[-- size] = null;
        return oldValue;
    }

    /**
     * 检查index是否在list的容量大小范围之内，否则抛出异常
     *
     * @param index
     */
    private void rangCheck(int index) {
        // TODO
    }
}
