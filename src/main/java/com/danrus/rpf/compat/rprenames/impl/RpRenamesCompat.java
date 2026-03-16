package com.danrus.rpf.compat.rprenames.impl;

//? if rprenames {
import com.hiword9.rprenames.mod.RPRenames;
import com.hiword9.rprenames.mod.item_group.RPRenamesItemGroup;
//? }

public class RpRenamesCompat {

    public static void init() {
        //? if rprenames {
        RpfParser parser = new RpfParser(RPRenames.updatableRenamesManager);

        RenamesBridge.itemSetter = parser::updateClientItem;
        RenamesBridge.parser = parser::parse;
        RenamesBridge.active = true;

        RPRenames.updatableRenamesManager.parsers().remove(RPRenames.itemModelParser);
        //? }
    }

    public static void update() {
        //? if rprenames
        RPRenamesItemGroup.update();
    }
}
