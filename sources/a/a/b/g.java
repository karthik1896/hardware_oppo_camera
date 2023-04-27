package a.a.b;

import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.entities.FilterItem;
import co.polarr.renderer.entities.FilterPackage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static List<FilterPackage> f84a = new ArrayList();

    static {
        FilterPackage filterPackage = new FilterPackage();
        filterPackage.pack_id = "Johnny_Filter_Common";
        filterPackage.pack_name = "Common";
        filterPackage.filters = new ArrayList();
        FilterItem filterItem = new FilterItem();
        filterItem.name = "人像风格2019新滤镜一";
        filterItem.id = FilterPackageUtil.PORTRAIT4_1;
        HashMap hashMap = new HashMap();
        Float valueOf = Float.valueOf(-0.45f);
        hashMap.put("vignette_amount", valueOf);
        Float valueOf2 = Float.valueOf(1.0f);
        hashMap.put("vignette_feather", valueOf2);
        Float valueOf3 = Float.valueOf(0.5f);
        hashMap.put("vignette_highlights", valueOf3);
        Float valueOf4 = Float.valueOf(0.0f);
        hashMap.put("vignette_roundness", valueOf4);
        hashMap.put("vignette_exposure", valueOf4);
        hashMap.put("vignette_size", valueOf2);
        hashMap.put("grain_size", valueOf4);
        Float valueOf5 = Float.valueOf(0.35f);
        hashMap.put("grain_amount", valueOf5);
        Float valueOf6 = Float.valueOf(0.78f);
        hashMap.put("grain_highlights", valueOf6);
        hashMap.put("grain_roughness", valueOf4);
        filterItem.state = hashMap;
        filterPackage.filters.add(filterItem);
        FilterItem filterItem2 = new FilterItem();
        filterItem2.name = "人像风格2019新滤镜一b";
        filterItem2.id = FilterPackageUtil.PORTRAIT4_1B;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("grain_size", valueOf4);
        hashMap2.put("grain_amount", valueOf5);
        hashMap2.put("grain_highlights", valueOf6);
        hashMap2.put("grain_roughness", valueOf4);
        filterItem2.state = hashMap2;
        filterPackage.filters.add(filterItem2);
        FilterItem filterItem3 = new FilterItem();
        filterItem3.name = "人像风格2019新滤镜一c";
        filterItem3.id = FilterPackageUtil.PORTRAIT4_1C;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("vignette_amount", valueOf);
        hashMap3.put("vignette_feather", valueOf2);
        hashMap3.put("vignette_highlights", valueOf3);
        hashMap3.put("vignette_roundness", valueOf4);
        hashMap3.put("vignette_exposure", valueOf4);
        hashMap3.put("vignette_size", valueOf2);
        filterItem3.state = hashMap3;
        filterPackage.filters.add(filterItem3);
        FilterItem filterItem4 = new FilterItem();
        filterItem4.name = "人像风格2019新滤镜三";
        filterItem4.id = FilterPackageUtil.PORTRAIT4_3;
        HashMap hashMap4 = new HashMap();
        hashMap4.put("overlay_amount", valueOf2);
        filterItem4.state = hashMap4;
        filterPackage.filters.add(filterItem4);
        f84a.add(filterPackage);
    }
}
