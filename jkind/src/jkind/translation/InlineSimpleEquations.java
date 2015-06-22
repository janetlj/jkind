package jkind.translation;

import java.util.Map;

import jkind.lustre.BoolExpr;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.IntExpr;
import jkind.lustre.Node;
import jkind.lustre.RealExpr;

public class InlineSimpleEquations {
	public static Node node(Node node) {
		Map<String, Expr> map = getInliningMap(node);
		return new SubstitutionVisitor(map).visit(node);
	}

	private static Map<String, Expr> getInliningMap(Node node) {
		ResolvingSubstitutionMap map = new ResolvingSubstitutionMap();
		for (Equation eq : node.equations) {
			if (isSimple(eq.expr)) {
				String id = eq.lhs.get(0).id;
				map.put(id, eq.expr);
			}
		}
		return map;
	}

	private static boolean isSimple(Expr e) {
		return isConstant(e) || e instanceof IdExpr;
	}

	private static boolean isConstant(Expr e) {
		return e instanceof BoolExpr || e instanceof IntExpr || e instanceof RealExpr;
	}
}
