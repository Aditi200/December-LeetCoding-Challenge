class Solution {
    public Node connect(Node root) {
   // Check if node contains children or not else return 
   if(root == null || (root.right == null && root.left == null))
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
		// call helper
        helper(q);
        return root;
    }
    
    public void helper(Queue<Node> q){
	// if queue is empty return and truncate all calls
        if(q.size() == 0)
            return ;
        Queue<Node> s = new LinkedList<>();
        Node prev = null;
		// q contains all the nodes from a level , add all the children from this level to new queue & call helper recursively 
        while(q.size() > 0){
            Node tmp = q.remove();
			//check if prev is not null set prev to point the next node in queue.
            if(prev != null)
                prev.next = tmp;
            prev = tmp;
			// Add nodes from next level to new queue and call helper.
            if(tmp.left != null)
                s.add(tmp.left);
            if(tmp.right != null)
                s.add(tmp.right);
        }
        helper(s);
    }
    
}