package com.epf.model;

import java.util.Objects;

public class Zombie {
    private Long id;
    private String name;
    private Integer health;
    private Integer damage;
    private Long mapId;

    public Zombie() { }
    public Zombie(Long id, String name, Integer health, Integer damage, Long mapId) {
        this.id = id; this.name = name; this.health = health; this.damage = damage; this.mapId = mapId;
    }
    public Long getId()                { return id; }
    public void setId(Long id)         { this.id = id; }
    public String getName()            { return name; }
    public void setName(String name)   { this.name = name; }
    public Integer getHealth()         { return health; }
    public void setHealth(Integer health) { this.health = health; }
    public Integer getDamage()         { return damage; }
    public void setDamage(Integer damage) { this.damage = damage; }
    public Long getMapId()             { return mapId; }
    public void setMapId(Long mapId)   { this.mapId = mapId; }

    @Override public String toString() {
        return "Zombie{id="+id+", name='"+name+"', health="+health+", damage="+damage+", mapId="+mapId+"}";
    }
    @Override public boolean equals(Object o) {
        if(this==o) return true;
        if(!(o instanceof Zombie)) return false;
        Zombie z=(Zombie)o;
        return Objects.equals(id,z.id)&&Objects.equals(name,z.name)&&Objects.equals(health,z.health)&&Objects.equals(damage,z.damage)&&Objects.equals(mapId,z.mapId);
    }
    @Override public int hashCode() {
        return Objects.hash(id,name,health,damage,mapId);
    }
}