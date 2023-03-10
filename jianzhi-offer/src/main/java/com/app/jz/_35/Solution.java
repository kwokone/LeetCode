package com.app.jz._35;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 * 示例:
 * 输入:{1,2,3,4,5 ,3,5,#,2,#}
 * 输出:{1,2,3,4,5,3,5,#,2,#}
 * 解析:我们将链表分为两段，前半部分{1,2,3,4,5}为ListNode，后半部分{3,5,#,2,#}是随机指针域表示。
 * 以上示例前半部分可以表示链表为的ListNode:1->2->3->4->5
 * 后半部分，3，5，#，2，#分别的表示为
 * 1的位置指向3，2的位置指向5，3的位置指向null，4的位置指向2，5的位置指向null
 */
public class Solution {

    /**
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     * <p>
     * 我们需要在一开始把所有的节点都创建出来，避免 random 找不到指向，同时观察上图，每个节点都通过 random 对应着一个新的节点，
     * 这种一一对应的关系，符合哈希表的特征
     * <p>
     * 此时的哈希表以原链表的节点作为键，新创建的节点作为值
     *
     * @param pHead
     * @return
     */
    public RandomListNode clone(RandomListNode pHead) {
        // 边界判断
        if (pHead == null) return null;
        // 从头节点开始遍历
        RandomListNode cur = pHead;
        // 哈希表结构Map存放已经创建的节点
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        while (cur != null) {

            // 遍历原链表
            RandomListNode newNode = new RandomListNode(cur.label);
            map.put(cur, newNode); // 下一节点和随机节点的哈希表

            cur = cur.next;
        }
        // 再次从链表的头节点遍历
        cur = pHead;

        while (cur!=null){

            RandomListNode valueCur = map.get(cur);

            RandomListNode keyNextNode = cur.next;
            RandomListNode valueNextNode = map.get(keyNextNode);

            valueCur.next = valueNextNode;

            // 寻找valueCur的radom节点
            RandomListNode keyRandomNode = cur.random;
            RandomListNode valueRandomNode = map.get(keyRandomNode);
            valueCur.random = valueRandomNode;

            cur =cur.next;



        }
        // 原链表节点 ---- 新链表节点
        // key  ---- value
        // cur  --- map.get(cur)
        // pHead --- map.get(pHead)
        return map.get(pHead);



    }


}
