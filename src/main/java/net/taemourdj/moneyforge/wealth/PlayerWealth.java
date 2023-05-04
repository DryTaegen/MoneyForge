package net.taemourdj.moneyforge.wealth;

import net.minecraft.nbt.CompoundTag;

public class PlayerWealth {
    private int wealth;
    private final int MIN_WEALTH = 0;


    public int getWealth(){
        return wealth;
    }

    public void addWealth(int add) {
        this.wealth += add;
    }

    public  void  subWealth(int sub) {
        if (this.wealth >= sub )
            this.wealth -= sub;
    }

    public void copyFrom(PlayerWealth source) {
        this.wealth =source.wealth;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("wealth", wealth);
    }
    public void loadNBTData(CompoundTag nbt){
        wealth = nbt.getInt("wealth");
    }
}
