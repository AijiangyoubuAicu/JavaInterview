import java.nio.ByteBuffer;

public class Demo01_Buffer {
    public static void main(String[] args) {

        // 新建一个缓冲区，其容量为 1024
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 查看核心变量的初始值
        System.out.println("容量：" + byteBuffer.capacity());
        System.out.println("上界：" + byteBuffer.limit());
        System.out.println("位置：" + byteBuffer.position());
        System.out.println("标记(目前可视为初始位置)：" + byteBuffer.mark());
        /* 输出结果
            容量：1024
            上界：1024
            位置：0
            标记(目前可视为初始位置)：java.nio.HeapByteBuffer[pos=0 lim=1024 cap=1024]
         */

        // 添加一些数据到缓冲区
        String talk = "lalalalala hahahahaha";
        byteBuffer.put(talk.getBytes());

        // 再次输出核心变量的值
        System.out.println("容量：" + byteBuffer.capacity());
        System.out.println("上界：" + byteBuffer.limit());
        System.out.println("位置：" + byteBuffer.position());
        System.out.println("标记：" + byteBuffer.mark());
        /* 输出结果
            容量：1024
            上界：1024
            位置：21
            标记：java.nio.HeapByteBuffer[pos=21 lim=1024 cap=1024]
         */

        // 切换到读模式
        byteBuffer.flip();
        System.out.println("容量：" + byteBuffer.capacity());
        System.out.println("上界：" + byteBuffer.limit());
        System.out.println("位置：" + byteBuffer.position());
        System.out.println("标记：" + byteBuffer.mark());
        /* 输出结果
            容量：1024
            上界：21
            位置：0
            标记：java.nio.HeapByteBuffer[pos=0 lim=21 cap=1024]
         */
        // 读取缓冲区的数据

        // 创建一个 limit() 大小的字节数组
        byte[] bytes = new byte[byteBuffer.limit()];
        // 将读取的数据装进字节数组中
        byteBuffer.get(bytes);
        // 输出数据
        System.out.println(new String(bytes, 0, bytes.length)); // lalalalala hahahahaha
        // 再次输出核心变量的值
        System.out.println("容量：" + byteBuffer.capacity());
        System.out.println("上界：" + byteBuffer.limit());
        System.out.println("位置：" + byteBuffer.position());
        System.out.println("标记：" + byteBuffer.mark());
        /* 输出结果
            容量：1024
            上界：21
            位置：21
            标记：java.nio.HeapByteBuffer[pos=21 lim=21 cap=1024]
         */

        // 清空缓冲区
        byteBuffer.clear();
        // 再次输出核心变量的值
        System.out.println("容量：" + byteBuffer.capacity());
        System.out.println("上界：" + byteBuffer.limit());
        System.out.println("位置：" + byteBuffer.position());
        System.out.println("标记：" + byteBuffer.mark());
        /* 输出结果
            容量：1024
            上界：1024
            位置：0
            标记：java.nio.HeapByteBuffer[pos=0 lim=1024 cap=1024]
         */

    }
}
