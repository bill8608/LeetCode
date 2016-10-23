/*
155. Min Stack   QuestionEditorial Solution  My Submissions
Total Accepted: 95915
Total Submissions: 381172
Difficulty: Easy
Contributors: Admin
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
Subscribe to see which companies asked this question

Hide Tags Stack Design
Hide Similar Problems (H) Sliding Window Maximum
*/

/*
Create two LinkedList and update them according to the push, pop.
*/

public class MinStack {

    /** initialize your data structure here. */
    List<Integer> stack;
    List<Integer> minStack;
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.add(x);
        if (minStack.size() == 0) {
            minStack.add(x);
        } else if (x < minStack.get(minStack.size() - 1)) {
                minStack.add(x);
        } else {
                minStack.add(minStack.get(minStack.size() - 1));
        }
    }
    public void pop() {
        stack.remove(stack.size() - 1);
        minStack.remove(minStack.size() - 1);
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
