package Offer.Chapter4;

import Offer.TreeNode;

public class SerializeAndDeserialize {
    private StringBuilder sb = new StringBuilder();
    private String[] nodes;
    private int index = -1;

    private void toSerial(TreeNode root){
        if (root == null){
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(',');
        toSerial(root.left);
        toSerial(root.right);
    }

    public String serialize(TreeNode root){
        toSerial(root);
        return sb.toString();
    }

    private TreeNode toDeserial(){
        if (!nodes[++index].equals("#")){
            TreeNode root = new TreeNode(Integer.valueOf(nodes[index]));
            root.left = toDeserial();
            root.right = toDeserial();
            return root;
        }
        return null;
    }

    public TreeNode deserailize(String str){
        if (str != null) nodes = str.split(",");
        return toDeserial();
    }

    public static void main(String[] args){
        TreeNode node7 = new TreeNode(11);
        TreeNode node6 = new TreeNode(9);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(10);
        TreeNode node3 = new TreeNode(7);
        TreeNode node2 = new TreeNode(6);
        TreeNode node1 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        SerializeAndDeserialize serializeAndDeserialize = new SerializeAndDeserialize();
        String sequence = serializeAndDeserialize.serialize(node1);
        System.out.println(sequence);

        TreeNode root = serializeAndDeserialize.deserailize(sequence);
        System.out.println(new SerializeAndDeserialize().serialize(root));
    }
    //8,6,10,#,#,5,#,#,7,9,#,#,11,#,#,
}
