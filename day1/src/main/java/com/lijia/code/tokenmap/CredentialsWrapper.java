package com.lijia.code.tokenmap;

public class CredentialsWrapper<T> {

    private int version;
    private T t;

    public CredentialsWrapper(int version, T t) {
        this.version = version;
        this.t = t;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "CredentialsWrapper{" +
                "version=" + version +
                ", t=" + t +
                '}';
    }
}
