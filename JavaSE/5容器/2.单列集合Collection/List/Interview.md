## ArrayList与Linked的区别
1.ArrayList是实现了基于**动态数组**的数据结构，因为地址是连续的，数据一旦存储好了，查询操作效率会比较高<br>
2.LinkedList基于**链表**的数据结构，地址是任意的，所以在开辟内存空间的时候不需要等一个连续地址，对于新增和删除的add和remove方法LinkedList是占优势的<br>
3.因为ArrayList的地址是连续的，ArrayList要移动数据，所以插入和删除操作效率较低
4.因为LinkedList要移动指针，所以查询操作性能较低

适用场景：<br>
当需要对数据进行对此访问的情况下选用ArrayList，当需要对数据多次增加删除修改采用LinkedList



