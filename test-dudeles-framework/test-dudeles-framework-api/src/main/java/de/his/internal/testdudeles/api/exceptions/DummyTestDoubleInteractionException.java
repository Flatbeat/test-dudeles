package de.his.internal.testdudeles.api.exceptions;

public final class DummyTestDoubleInteractionException extends RuntimeException {

    private static final long serialVersionUID = -8419665727863886589L;

    @Override
    public String getMessage() {
        return "Dummy test doubles are not intended for use!";
    }

}
