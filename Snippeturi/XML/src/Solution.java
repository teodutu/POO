import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.*;


abstract class BaseObject {
    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    public static class ListObject extends BaseObject {
        public final List<BaseObject> objectList;

        public ListObject(List<BaseObject> objectList) {
            this.objectList = objectList;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    public static final class MapObject extends BaseObject {
        public final Map<String, BaseObject> objectMap;

        public MapObject(Map<String, BaseObject> objectMap) {
            this.objectMap = objectMap;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    public static final class StringObject extends BaseObject {
        public final String value;

        public StringObject(String value) {
            this.value = value;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    public interface Visitor {
        public void visit(ListObject object);

        public void visit(MapObject object);

        public void visit(StringObject object);
    }

    public abstract void accept(Visitor visitor);
}

/* Write all your code here! */
class XMLVisitor implements BaseObject.Visitor {
    /* Use this value when printing tabs for indentation. */
    private static String TAB = "    ";
    private int indentationLevel = 0;

    public void visit(BaseObject.ListObject object) {
        /* DONE: implement visit for ListObject. */
        printText("<list length=\"" + object.objectList.size() + "\">");
        indentationLevel++;

        for (BaseObject o : object.objectList) {
            o.accept(this);
        }

        indentationLevel--;
        printText("</list>");
    }

    public void visit(BaseObject.MapObject object) {
        /* DONE: implement visit for MapObject. */
        printText("<object>");
        indentationLevel++;

        for (Map.Entry<String, BaseObject> entry : object.objectMap.entrySet()) {
            printText("<entry key=\"" + entry.getKey() + "\">");

            indentationLevel++;
            entry.getValue().accept(this);
            indentationLevel--;

            printText("</entry>");
        }

        indentationLevel--;
        printText("</object>");
    }

    public void visit(BaseObject.StringObject object) {
        /* DONE: implement visit for StringObject. */
        printText("<string>");

        indentationLevel++;
        printText("\"" + object.value + "\"");
        indentationLevel--;

        printText("</string>");
    }

    private void printTabs() {
        for (int i = 0; i < indentationLevel; i++) {
            System.out.print(TAB);
        }
    }

    private void printText(String text) {
        printTabs();
        System.out.println(text);
    }
}


public class Solution {
    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    private static BaseObject convert(Object element) {
        if (element instanceof JSONArray) {
            JSONArray arrayObject = (JSONArray) element;

            List<BaseObject> list = new ArrayList<>();

            for (Object object : arrayObject) {
                list.add(convert(object));
            }

            return new BaseObject.ListObject(list);
        } else if (element instanceof JSONObject) {
            JSONObject mapObject = (JSONObject) element;
            Map<String, BaseObject> map = new HashMap<>();

            for (Object keyObject : mapObject.keySet()) {
                String key = (String) keyObject;
                Object nestedObject = mapObject.get(key);

                map.put(key, convert(nestedObject));
            }

            return new BaseObject.MapObject(map);
        } else {
            String stringObject = (String) element;

            return new BaseObject.StringObject(stringObject);
        }
    }

    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        InputStreamReader reader = new InputStreamReader(System.in);
        Object parsed = null;

        try {
            parsed = parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BaseObject root = convert(parsed);

        root.accept(new XMLVisitor());
    }
}import org.json.simple.JSONArray;
        import org.json.simple.JSONObject;
        import org.json.simple.parser.JSONParser;

        import java.io.*;
        import java.util.*;


abstract class BaseObject {
    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    public static class ListObject extends BaseObject {
        public final List<BaseObject> objectList;

        public ListObject(List<BaseObject> objectList) {
            this.objectList = objectList;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    public static final class MapObject extends BaseObject {
        public final Map<String, BaseObject> objectMap;

        public MapObject(Map<String, BaseObject> objectMap) {
            this.objectMap = objectMap;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    public static final class StringObject extends BaseObject {
        public final String value;

        public StringObject(String value) {
            this.value = value;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    public interface Visitor {
        public void visit(ListObject object);

        public void visit(MapObject object);

        public void visit(StringObject object);
    }

    public abstract void accept(Visitor visitor);
}

/* Write all your code here! */
class XMLVisitor implements BaseObject.Visitor {
    /* Use this value when printing tabs for indentation. */
    private static String TAB = "    ";
    private int indentationLevel = 0;

    public void visit(BaseObject.ListObject object) {
        /* DONE: implement visit for ListObject. */
        printText("<list length=\"" + object.objectList.size() + "\">");
        indentationLevel++;

        for (BaseObject o : object.objectList) {
            o.accept(this);
        }

        indentationLevel--;
        printText("</list>");
    }

    public void visit(BaseObject.MapObject object) {
        /* DONE: implement visit for MapObject. */
        printText("<object>");
        indentationLevel++;

        for (Map.Entry<String, BaseObject> entry : object.objectMap.entrySet()) {
            printText("<entry key=\"" + entry.getKey() + "\">");

            indentationLevel++;
            entry.getValue().accept(this);
            indentationLevel--;

            printText("</entry>");
        }

        indentationLevel--;
        printText("</object>");
    }

    public void visit(BaseObject.StringObject object) {
        /* DONE: implement visit for StringObject. */
        printText("<string>");

        indentationLevel++;
        printText("\"" + object.value + "\"");
        indentationLevel--;

        printText("</string>");
    }

    private void printTabs() {
        for (int i = 0; i < indentationLevel; i++) {
            System.out.print(TAB);
        }
    }

    private void printText(String text) {
        printTabs();
        System.out.println(text);
    }
}


public class Solution {
    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    private static BaseObject convert(Object element) {
        if (element instanceof JSONArray) {
            JSONArray arrayObject = (JSONArray) element;

            List<BaseObject> list = new ArrayList<>();

            for (Object object : arrayObject) {
                list.add(convert(object));
            }

            return new BaseObject.ListObject(list);
        } else if (element instanceof JSONObject) {
            JSONObject mapObject = (JSONObject) element;
            Map<String, BaseObject> map = new HashMap<>();

            for (Object keyObject : mapObject.keySet()) {
                String key = (String) keyObject;
                Object nestedObject = mapObject.get(key);

                map.put(key, convert(nestedObject));
            }

            return new BaseObject.MapObject(map);
        } else {
            String stringObject = (String) element;

            return new BaseObject.StringObject(stringObject);
        }
    }

    /* DO NOT MODIFY ANYTHING HERE! WRITE ALL YOUR CODE IN THE XMLVisitor CLASS */
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        InputStreamReader reader = new InputStreamReader(System.in);
        Object parsed = null;

        try {
            parsed = parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BaseObject root = convert(parsed);

        root.accept(new XMLVisitor());
    }
}