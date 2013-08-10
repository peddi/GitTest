package peddi.adftutorial.demo.model.service;

import java.util.HashMap;
import java.util.Map;

import oracle.binding.DataControl;

import oracle.binding.ManagedDataControl;
import oracle.binding.OperationBinding;

import oracle.binding.TransactionalDataControl;

import oracle.jbo.client.Configuration;

public class AMServiceTest implements TransactionalDataControl, ManagedDataControl {
    public static void main(String[] args) {
        String amDef = "peddi.adftutorial.demo.model.service.HRSystemAM";
        String config = "HRSystemAMLocal";
        HRSystemAMImpl am = null;
        try {
            // creates or acquires an AM instance from the pool using
            // the specified configuration.
            am = (HRSystemAMImpl)Configuration.createRootApplicationModule(amDef, config);
            //Invoke business methods on AM
            am.printPeddi();
        } finally {
            //Release the specified AM
            //true for the second parameter removes the
            //application module,
            //'false' causes to check in application module
            //instance to the pool for future use
            if (am != null)
                Configuration.releaseRootApplicationModule(am, true);
        }
    }
    public void printPeddi(){
        String amDef = "peddi.adftutorial.demo.model.service.HRSystemAM";
        String config = "HRSystemAMLocal";
        HRSystemAMImpl am = null;
        try {
            // creates or acquires an AM instance from the pool using
            // the specified configuration.
            am = (HRSystemAMImpl)Configuration.createRootApplicationModule(amDef, config);
            //Invoke business methods on AM
            am.printPeddi();
        } finally {
            //Release the specified AM
            //true for the second parameter removes the
            //application module,
            //'false' causes to check in application module
            //instance to the pool for future use
            if (am != null)
                Configuration.releaseRootApplicationModule(am, true);
        }
    }

    public String getName() {
        return null;
    }

    public void release() {
    }

    public Object getDataProvider() {
        return null;
    }

    public boolean invokeOperation(Map p0, OperationBinding p1) {
        return false;
    }

    public boolean isTransactionDirty() {
        return false;
    }

    public void rollbackTransaction() {
    }

    public void commitTransaction() {
    }

    public void beginRequest(HashMap p0) {
    }

    public void endRequest(HashMap p0) {
    }

    public boolean resetState() {
        return false;
    }
}
