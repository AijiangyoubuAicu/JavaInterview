package array;

import java.util.Arrays;

public class ArrayDeno {

    private int[] elements = new int[0];

    // 增

    /**
     * 添加一个数据
     * @param element
     */
    public void add(int element) {
        int[] newArr = new int[this.elements.length + 1];

        for (int i = 0; i < this.elements.length; i++) {
            newArr[i] = this.elements[i];
        }

        newArr[this.elements.length] = element;
        this.elements = newArr;
    }

    public void insert(int index, int element) {
        int[] newArr = new int[this.elements.length + 1];

        for (int i = 0; i < this.elements.length; i++) {
            if (i < index) {
                newArr[i] = this.elements[i];
            } else {
                newArr[i + 1] = this.elements[i];
            }
        }

        newArr[index] = element;
        this.elements = newArr;
    }

    // 删

    /**
     * 删除对应索引数据
     * @param index
     */
    public void delete(int index) {
        if (index >= 0 && index <= this.elements.length - 1) {
            int[] newArr = new int[this.elements.length - 1];

            for (int i = 0; i < newArr.length; i++) {
                if (i < index) {
                    newArr[i] = this.elements[i];
                } else {
                    newArr[i] = this.elements[i + 1];
                }
            }

            this.elements = newArr;
        } else {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
    }

    // 改

    /**
     * 更改数组下标 index 的数组
     * @param index
     * @param element
     */
    public void set(int index, int element) {
        if (index >= 0 && index <= this.elements.length - 1) {
            this.elements[index] = element;
        } else {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
    }

    // 查

    /**
     * 数组长度
     *
     * @return
     */
    public int size() {
        return this.elements.length;
    }

    /**
     * 获取对应索引的数据
     * @param index
     * @return
     */
    public int get(int index) {
        if (index >= 0 && index <= this.elements.length - 1) {
            return this.elements[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
    }

    /**
     * 输出数组的数据
     */
    public void show() {
        System.out.println(Arrays.toString(elements));
    }

    /**
     * 查询对应数组的下标
     * @param target
     * @return
     */
    public int search(int target) {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i] == target) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 二分查询法
     * @param target
     * @return
     */
    public int brnarySearch(int target) {
        int begin = 0;
        int end = this.elements.length - 1;

        for (int mid = (begin + end) / 2; begin < end; mid = (begin + end) / 2) {
            if (this.elements[mid] == target) {
                return mid;
            }

            if (this.elements[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }
}
