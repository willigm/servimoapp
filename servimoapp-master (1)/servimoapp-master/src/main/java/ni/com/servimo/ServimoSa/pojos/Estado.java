package ni.com.servimo.ServimoSa.pojos;

public enum Estado {
    ACTIVO(1), INACTIVO(2),SUSPENDIDO(3);

    private int value;

    Estado(int value){
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    private void setValue(int value){
        this.value = value;
    }

}
