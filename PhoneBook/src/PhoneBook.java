import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PhoneBook {
    Map<String, String> map = new TreeMap<>();
    Map<String, Integer> callMap = new HashMap<>();
    List list = new ArrayList();
    int phoneCalls = 0;

    public void outgoingCalls() {
        for (int i = 0; i < list.size(); i++) {
            String key = (String) list.get(i);
            if (callMap.containsKey(key)) {
                int freq = callMap.get(key);
                freq++;
                callMap.put(key, freq);

            } else {
                callMap.put(key, 1);
            }
        }
        System.out.println(callMap);

    }

    public Map<String, Integer> getCallMap() {
        return callMap;
    }

    public void setCallMap(Map<String, Integer> callMap) {
        this.callMap = callMap;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getPhoneCalls() {
        return phoneCalls;
    }

    public void setPhoneCalls(int phoneCalls) {
        this.phoneCalls = phoneCalls;
    }

    public void call(String name) {
        phoneCalls++;
        list.add(map.get(name));

    }

    public PhoneBook() {

    }

    public PhoneBook(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()) {

            String name = scanner.next();
            String phone = scanner.next();
            if ((phone.substring(0, 1).equals("0") && (phone.substring(1,3).equals("87") ||
                    phone.substring(1,3).equals("88") || phone.substring(1,3).equals("89") ) &&
                    phone.substring(3,4).matches( "[2-9]") && phone.length() == 10) ||

                    (phone.substring(0,2) .equals("00") && phone.substring(2,5) .equals("359") &&
                            (phone.substring(5,7).equals("87") || phone.substring(5,7).equals("88")
                            || phone.substring(5,7).equals("89") ) &&
                            phone.substring(7,8).matches( "[2-9]") && phone.length() == 14) ||


                    (phone.substring(0,4).equals("+359")) && (phone.substring(4,6).equals("87") ||
                            phone.substring(4,6).equals("88") || phone.substring(4,6).equals("89") ) &&
                            phone.substring(6,7).matches( "[2-9]") && phone.length() == 13) {

                map.put(name, phone);
            }

        }
        scanner.close();

    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }


    public void addNewContact(String name, String phoneNumber) {
        map.put(name, phoneNumber);
    }

    public void deleteContact(String name) {
        map.remove(name);
    }

    public String accessPhoneNumberByName(String name) {
            return map.get(name);

    }

    public void printContacts () {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
        }
    }


}


