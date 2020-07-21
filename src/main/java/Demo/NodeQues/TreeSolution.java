package Demo.NodeQues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeSolution {
    ArrayList<Integer> list =new ArrayList<>();

    //递归前序遍历
    //第一要素：明确你这个函数想要干什么
    //函数功能：进行先序遍历二叉树
    public List<Integer>  preOrderTraversal(TreeNode root){
        //寻找递归结束条件
        if(root ==null)
            return list;

        list.add(root.val);

        if (root.left!=null){//左
            preOrderTraversal(root.left);
        }

        if (root.right!=null){//右
            preOrderTraversal(root.right);
        }

        return list;
    }

    //递归中序遍历遍历
    //第一要素：明确你这个函数想要干什么
    //函数功能：进行中序遍历二叉树
    public List<Integer>  inOrderTraversal(TreeNode root){
        //寻找递归结束条件
        if(root ==null)
            return list;

        if (root.left!=null){//左
            preOrderTraversal(root.left);
        }

        list.add(root.val);//中

        if (root.right!=null){//右
            preOrderTraversal(root.right);
        }
        return list;
    }

    //递归后序遍历遍历
    //第一要素：明确你这个函数想要干什么
    //函数功能：进行中序遍历二叉树
    public List<Integer>  postOrderTraversal(TreeNode root){
        //寻找递归结束条件
        if(root ==null)
            return list;

        if (root.left!=null){//左
            preOrderTraversal(root.left);
        }
        if (root.right!=null){//右
            preOrderTraversal(root.right);
        }
        list.add(root.val);//中


        return list;
    }

    //非递归方法 前序遍历
    public List<Integer> preOderTraversal1(TreeNode root){
        LinkedList<TreeNode> stack =new LinkedList<>();
        LinkedList<Integer> res =new LinkedList<>();
        if (root==null){
            return res;
        }
           stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node =stack.pollLast();
            res.add(node.val);
            if (node.right!=null){
                stack.add(node.right);
            }
            if (node.left!=null){
                stack.add(node.left);
            }
        }
        return res;
    }

    //非递归方法 中序遍历
    public List<Integer> inOderTraversal1(TreeNode root){
        Stack<TreeNode> stack =new Stack<>();
        List<Integer> res =new ArrayList<>();

        TreeNode curr =root;

        while(curr!=null||!stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            res.add(curr.val);
            curr=curr.right;
        }
        return res;
    }

    //非递归方法 后序遍历
    public List<Integer> postOderTraversal1(TreeNode root){
        Stack<TreeNode> stack =new Stack<>();
        List<Integer> res =new ArrayList<>();
        TreeNode curr =root;
        TreeNode last =null;

        while(curr!=null||!stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.peek();
            if (curr.right==null||curr.right==last){
                res.add(curr.val);
                curr=stack.pop();
                last=curr;
                curr=null;
            }else {
                curr=curr.right;
            }
        }
        return res;
    }

    /**
     *     非递归方法 后序遍历（取巧）
     *     已知后序遍历的节点访问顺序为：左 → 右 → 中；
     *     将这个次序颠倒过来：中 → 右 → 左；
     *     有没有想到前序遍历的节点访问顺序呢？
     *     中 → 左 → 右；因此，我们可以将前序遍历代码中的压栈顺序进行调整
     */
    public List<Integer> postOderTraversal2(TreeNode root){
        LinkedList<TreeNode> stack =new LinkedList<>();
        LinkedList<Integer> res =new LinkedList<>();
        if (root==null){
            return res;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node =stack.pollLast();
            res.addFirst(node.val);
            if (node.left!=null){
                stack.add(node.left);
            }
            if (node.right!=null){
                stack.add(node.right);
            }

        }
        return res;
    }
}
