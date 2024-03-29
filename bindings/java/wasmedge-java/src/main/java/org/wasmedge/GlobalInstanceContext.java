package org.wasmedge;

public class GlobalInstanceContext {
    private GlobalTypeContext globalTypeContext;
    private WasmEdgeValue value;
    private long pointer;

    private GlobalInstanceContext(long pointer) {
        this.pointer = pointer;
    }

    public GlobalInstanceContext(GlobalTypeContext typeCxt,
                                 WasmEdgeValue value) {
        this.globalTypeContext = typeCxt;
        this.value = value;
        nativeInit(typeCxt, value);
    }

    private native void nativeInit(GlobalTypeContext typeCxt, WasmEdgeValue value);

    public GlobalTypeContext getGlobalType() {
        return globalTypeContext;
    }

    private native void nativeSetValue(WasmEdgeValue value);

    public WasmEdgeValue getValue() {
        return this.value;
    }

    public void setValue(WasmEdgeValue value) {
        this.value = value;
        nativeSetValue(value);
    }

    public native void delete();
}
