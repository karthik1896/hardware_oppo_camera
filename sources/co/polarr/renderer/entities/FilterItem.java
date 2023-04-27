package co.polarr.renderer.entities;

import a.a.b.e.t;
import java.util.Iterator;
import java.util.Map;

public class FilterItem {
    public Map<String, Object> comments;
    public String description;
    public String id;
    public Object name;
    public Map<String, Object> state;

    public String filterName(String str) {
        Object next;
        Object obj = this.name;
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
                    next = ((Map) this.name).get(next2);
                    break;
                }
            }
        }
        if (((Map) this.name).isEmpty()) {
            return "";
        }
        next = ((Map) this.name).values().iterator().next();
        return next.toString();
    }

    public void updateStates() {
        Map<String, Object> map = this.state;
        if (map != null) {
            for (String next : map.keySet()) {
                this.state.put(next, t.a(next, this.state.get(next)));
            }
        }
    }
}
