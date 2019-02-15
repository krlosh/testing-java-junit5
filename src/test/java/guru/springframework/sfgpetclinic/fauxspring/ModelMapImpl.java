package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model {
    private final Map<String, Object> modelData;

    public ModelMapImpl() {
        this.modelData = new HashMap<>();
    }

    @Override
    public void addAttribute(String key, Object o) {
        modelData.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        modelData.put("" +o.hashCode(), o);
    }

    public Map<String, Object> getModelData() {
        return modelData;
    }
}
