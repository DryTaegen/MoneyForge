package net.taemourdj.moneyforge.wealth;

import net.minecraft.nbt.CompoundTag;

public class PlayerWealth {
    //player wealth class. Tracks the wealth and related methods.
    private int wealth;

    //cannot go into debt.
    private final int MIN_WEALTH = 0;


    //getter
    public int getWealth(){
        return wealth;
    }

    // called when a coin is used
    public void addWealth(int add) {
        this.wealth += add;
    }

    //Not yet implemented. Used for trading
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
