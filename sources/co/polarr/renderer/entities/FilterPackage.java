package co.polarr.renderer.entities;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FilterPackage {
    public List<FilterItem> filters;
    public int is_free;
    public LangName pack_description;
    public String pack_id;
    public String pack_maker;
    public Object pack_name;
    public List<String> preview_images;
    public int version;

    public String packageName(String str) {
        Object next;
        Object obj = this.pack_name;
        if (!(obj instanceof Map)) {
            return obj.toString();
        }
        if (str != null) {
            Iterator it = ((Map) obj).keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next2 = it.next();
                if (str.equals(next2)) {
                    next = ((Map) this.pack_name).get(next2);
                    break;
                }
            }
        }
        if (((Map) this.pack_name).isEmpty()) {
            return "";
        }
        next = ((Map) this.pack_name).values().iterator().next();
        return next.toString();
    }
}
