package ru.levelup.bank.domain;

public enum PaymentStatus {

    NEW(1, true),
    CONFIRMED(2, true),
    DONE(3, false),
    FAILED(4, false);

    private int sqlCode;
    private boolean canCancel;

    PaymentStatus(int sqlCode, boolean canCancel) {
        this.sqlCode = sqlCode;
    }

    public int getSqlCode() {
        return sqlCode;
    }

    public PaymentStatus findEnumOrNull(String s) {
        for (PaymentStatus status: values()) {
            if (status.name().equals(s.toUpperCase())) {
                return status;
            }
        }
        return null;
    }
}
