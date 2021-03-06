package nodes;

/**
 * Substraction PIPCalcNode
 * @author Kelly Vo 6978
 * @class CSCI 142 Johnson
 */
public class SubtractionNode extends BinaryOperatorNode {
    /**
     * Constructor that sets the left/right children and sets the operator to the
     * string - The precedence is set to ADD_SUBTRACT
     * @param left - the PIPCalcNode representing the left child
     * @param right - the PIPCalcNode representing the right child
     */
    public SubtractionNode(PIPCalcNode left, PIPCalcNode right){
        super(left, right, Precedence.ADD_SUBTRACT, "-");
    }

    /**
     * Evaluates the node to determine its integer value
     * @return the integer value of this node
     */
    public int evaluate(){
        return this.leftChild.evaluate() - this.rightChild.evaluate();
    }
}
