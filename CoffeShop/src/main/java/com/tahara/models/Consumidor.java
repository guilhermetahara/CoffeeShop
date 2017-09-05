package com.tahara.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consumidor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long consumidorId;

    private String consumidorNome;

    public long getConsumidorId() {
        return consumidorId;
    }

    public void setConsumidorId(long consumidorId) {
        this.consumidorId = consumidorId;
    }

    public String getConsumidorNome() {
        return consumidorNome;
    }

    public void setConsumidorNome(String consumidorNome) {
        this.consumidorNome = consumidorNome;
    }
}
