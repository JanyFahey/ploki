package org.wasmedge;

import java.util.List;

public class ASTModuleContext {
    private long pointer;

    public ASTModuleContext() {
    }

    private ASTModuleContext(long pointer) {
        this.pointer = pointer;
    }

    public native List<ImportTypeContext> listImports();

    public native List<ExportTypeContext> listExports();

    public native void delete();
}
