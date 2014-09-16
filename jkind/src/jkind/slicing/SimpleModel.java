package jkind.slicing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jkind.lustre.Type;
import jkind.lustre.values.Value;
import jkind.solvers.Model;
import jkind.solvers.ModelFunction;
import jkind.util.StreamIndex;

public class SimpleModel extends Model {
	private final Map<String, Value> values = new HashMap<>();
	private final Map<String, ModelFunction> functions = new HashMap<>();
	
	public SimpleModel() {
		super(Collections.<String, Type> emptyMap());
	}

	public void addValue(StreamIndex si, Value value) {
		values.put(si.getEncoded().str, value);
	}

	@Override
	public Value getValue(String name) {
		return values.get(name);
	}

	@Override
	public Set<String> getVariableNames() {
		return values.keySet();
	}

	public void addFunction(String name, ModelFunction function) {
		functions.put(name, function);
	}
	
	@Override
	public Set<String> getFunctionNames() {
		return functions.keySet();
	}

	@Override
	public ModelFunction getFunction(String name) {
		return functions.get(name);
	}
}
