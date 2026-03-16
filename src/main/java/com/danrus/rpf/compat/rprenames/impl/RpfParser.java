package com.danrus.rpf.compat.rprenames.impl;

//? if rprenames {
import com.hiword9.rprenames.api.core.renames_manager.RenamesManager;
import com.hiword9.rprenames.mod.impl.rename.ItemModelRename;
import com.hiword9.rprenames.api.ext.renames_manager.parser.Parser;
import com.hiword9.rprenames.mod.impl.renames_manager.updatable.parser.item_model.ItemModelData;
import com.hiword9.rprenames.mod.impl.renames_manager.updatable.parser.item_model.ItemModelDataExplorer;
import com.hiword9.rprenames.mod.impl.renames_manager.updatable.parser.item_model.ItemModelParser;
import com.hiword9.rprenames.mod.impl.renames_manager.updatable.parser.item_model.condition.ItemModelCondition;
import com.hiword9.rprenames.mod.impl.renames_manager.updatable.parser.item_model.condition.SelectCondition;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.properties.select.ComponentContents;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.*;

public class RpfParser extends ItemModelParser {

    private List<Map<ResourceLocation, ClientItem>> listItemAssets = new ArrayList<>();

    public RpfParser(RenamesManager<? super ItemModelRename> renamesManager) {
        super(renamesManager);
    }

    public void updateClientItem(List<Map<ResourceLocation, ClientItem>> itemAssets) {
        this.listItemAssets = itemAssets;
    }

    public void parse(ResourceManager resourceManager, ProfilerFiller profiler) {
        for (Map<ResourceLocation, ClientItem> itemAssets : listItemAssets) {
            this.updateItemAssets(itemAssets);
            super.parse(resourceManager, profiler);
        }


    }

}
//? }
