package com.app.jz._30;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，
 * 输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素
 *
 * 我们都知道栈结构的push、pop、top操作都是O(1)，但是min函数做不到，
 * 于是想到在push的时候就将最小值记录下来，由于栈先进后出的特殊性，
 * 我们可以构造一个单调栈，保证栈内元素都是递增的，栈顶元素就是当前最小的元素。
 *
 * step 1：使用一个栈记录进入栈的元素，正常进行push、pop、top操作。
 * step 2：使用另一个栈记录每次push进入的最小值。
 * step 3：每次push元素的时候与第二个栈的栈顶元素比较，若是较小，则进入第二个栈，若是较大，则第二个栈的栈顶元素再次入栈，因为即便加了一个元素，它依然是最小值。于是，每次访问最小值即访问第二个栈的栈顶。
 */
public class Solution {

    Stack<Integer> s1 = new Stack<>(); // 用于栈的push与pop
    Stack<Integer> s2 = new Stack<>(); // 用于记录最小的min

    public void push(int node){

        s1.push(node);

        // 空或者新元素 较小，则入栈
        if (s2.isEmpty() || s2.peek() > node) s2.push(node);
        else {
            // 将先前最小的元素重复加入栈顶
            s2.push(s2.peek());

        }


    }

    public void pop(){

        s1.pop();
        s2.pop();


    }

    public int top(){
        return s1.peek();
    }

    public int min(){
        return s2.peek();
    }
}
