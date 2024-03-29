package org.wasmedge;

import java.util.List;

public class ExecutorContext {
    private long pointer;

    public ExecutorContext(ConfigureContext configureContext, StatisticsContext statisticsContext) {
        nativeInit(configureContext, statisticsContext);
    }

    private native void nativeInit(ConfigureContext configureContext, StatisticsContext statisticsContext);


    public native ModuleInstanceContext instantiate(StoreContext storeContext, ASTModuleContext astModuleContext);

    public native void invoke(FunctionInstanceContext functionInstanceContext,
                              List<WasmEdgeValue> params, List<WasmEdgeValue> returns);


    private int[] getValueTypeArray(List<WasmEdgeValue> values) {

        int[] types = new int[values.size()];

        for (int i = 0; i < values.size(); i++) {
            types[i] = values.get(i).getType().ordinal();
        }
        return types;
    }

    private WasmEdgeValue[] valueListToArray(List<WasmEdgeValue> values) {
        WasmEdgeValue[] valuesArray = new WasmEdgeValue[values.size()];
        values.toArray(valuesArray);
        return valuesArray;
    }

    public native ModuleInstanceContext register(StoreContext storeCxt,
                                ASTModuleContext astCxt,
                                String modeName);

    public native void registerImport(StoreContext storeCxt, ModuleInstanceContext moduleInstanceContext);

    public native void delete();
}
