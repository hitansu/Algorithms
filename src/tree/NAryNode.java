package tree;

import java.util.ArrayList;
import java.util.List;

public class NAryNode {

	int data;
	List<NAryNode> childs;
	
	public NAryNode(int data) {
		this.data= data;
		this.childs= new ArrayList<>();
	}
}
