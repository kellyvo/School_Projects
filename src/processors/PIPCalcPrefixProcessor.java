package processors;

import nodes.BinaryOperatorNode;
import nodes.PIPCalcNode;
import nodes.UnaryOperatorNode;

/**
 * Class to process PIPCalc ecpressions using prefix notation
 * @author Kelly Vo kdv6978
 * @class CSCI 142 Johnson
 */
public class PIPCalcPrefixProcessor extends PIPCalcProcessor{
    /**
     * Constructor of PIPCalcPrefixProcessor
     */
    public PIPCalcPrefixProcessor(){}

    /**
     * Constructs and assigns a PIPCalc tree from the provided list of
     * PIPCalcNode tokens using prefix notation
     * Specified by: constructTree in class PIPCalcProcessor
     * @param tokens - list of PIPCalcNodes used to create the pares tree
     */
    public void constructTree(java.util.ArrayList<java.lang.String> tokens) {
        this.tree = helper(tokens);
    }

    /**
     * Helper function that uses recursion to construct the tree in prefix
     * @param tokens - list of PIPCalcNodes used to create the pares tree
     * @return returns a PIPCalcNode
     */
    public PIPCalcNode helper(java.util.ArrayList<java.lang.String> tokens){
        PIPCalcNode node = createPIPCalcNode(tokens.remove(0));
        if(node.getNodeType() == PIPCalcNode.NodeType.BinaryOperation){
            BinaryOperatorNode binary = (BinaryOperatorNode) node;
            PIPCalcNode right = helper(tokens);
            PIPCalcNode left = helper(tokens);
            binary.setLeftChild(left);
            binary.setRightChild(right);
            return binary;
        }
        if(node.getNodeType() == PIPCalcNode.NodeType.UnaryOperation){
            UnaryOperatorNode unary = (UnaryOperatorNode) node;
            PIPCalcNode child = helper(tokens);
            unary.setChild(child);
            return unary;
        }
        return node;
    }
}
