package brushexercises.day45;

import comm.TreeNode;

/**
 * @Describe : 108. 将有序数组转换为二叉搜索树
 * @Author : sunzhenning
 * @Since : 2022/7/13 20:23
 */
public class NO_108_ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0, nums.length-1);
    }


    private TreeNode dfs(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int mid = left +(right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid-1);
        root.right = dfs(nums, mid+1, right);
        return root;
    }
}
