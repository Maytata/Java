import java.util.*;

public class Parameters {
    public static void fill_params(Map<Integer, String> params, String param, Set<Notebook> nb_set) {
        int counter = 1;
        Set<String> search_set = new HashSet<>();
        switch (param) {
            case "model" -> {
                for (var item : nb_set) {
                    search_set.add(item.getModel());
                }
            }
            case "OS" -> {
                for (var item : nb_set) {
                    search_set.add(item.getOS());
                }
            }
            case "ROM" -> {
                for (var item : nb_set) {
                    search_set.add(Integer.toString(item.getROM()));
                }
            }
            case "memory" -> {
                for (var item : nb_set) {
                    search_set.add(Integer.toString(item.getMemory()));
                }
            }
            case "screensize" -> {
                for (var item : nb_set) {
                    search_set.add(Integer.toString(item.getScreensize()));
                }
            }
            case "color" -> {
                for (var item : nb_set) {
                    search_set.add(item.getColor());
                }
            }
            case "price" -> {
                for (var item : nb_set) {
                    search_set.add(Double.toString(item.getPrice()));
                }
            }
        }
        if (param.equals("ROM") || param.equals("memory") || param.equals("screensize")){
            List<Integer> sorted_list = new ArrayList<>();
            for (String item : search_set){
                sorted_list.add(Integer.parseInt(item));
            }
            Collections.sort(sorted_list);
            for (Integer res : sorted_list) {
                params.put(counter, res.toString());
                counter++;
            }
        } else if (param.equals("price")) {
            List<Double> sorted_list = new ArrayList<>();
            for (String item : search_set){
                sorted_list.add(Double.parseDouble(item));
            }
            Collections.sort(sorted_list);
            for (Double res : sorted_list) {
                params.put(counter, res.toString());
                counter++;
            }
        } else {
            for (String res : search_set) {
                params.put(counter, res);
                counter++;
            }
        }
    }

    public static void search_result(Set<Notebook> nb_set, String final_search, String field, Boolean is_numeric) {
        if (!is_numeric) {
            switch (field) {
                case "model" -> {
                    System.out.println("\nAll for model " + final_search + ":");
                    for (var item : nb_set) {
                        if (final_search.equals(item.getModel())) {
                            System.out.print(item);
                        }
                    }
                }
                case "OS" -> {
                    System.out.println("\nAll for OS " + final_search + ":");
                    for (var item : nb_set) {
                        if (final_search.equals(item.getOS())) {
                            System.out.print(item);
                        }
                    }
                }
                case "color" -> {
                    System.out.println("\nAll for color \"" + final_search + "\":");
                    for (var item : nb_set) {
                        if (final_search.equals(item.getColor())) {
                            System.out.print(item);
                        }
                    }
                }
            }
        } else {
            switch (field) {
                case "screensize" -> {
                    System.out.println("\nAll with screensize " + final_search + "\" and over:");
                    for (var item : nb_set) {
                        if (Integer.parseInt(final_search) <= item.getScreensize()) {
                            System.out.print(item);
                        }
                    }
                }
                case "ROM" -> {
                    System.out.println("\nAll with ROM " + final_search + "Mb and over:");
                    for (var item : nb_set) {
                        if ((Integer.parseInt(final_search) <= item.getROM())) {
                            System.out.print(item);
                        }
                    }
                }
                case "memory" -> {
                    System.out.println("\nAll with memory " + final_search + "Mb and over:");
                    for (var item : nb_set) {
                        if ((Integer.parseInt(final_search) <= item.getMemory())) {
                            System.out.print(item);
                        }
                    }
                }
                case "price" -> {
                    System.out.println("\nAll for " + final_search + "$ and over:");
                    for (var item : nb_set) {
                        if ((Double.parseDouble(final_search) <= item.getPrice())) {
                            System.out.print(item);
                        }
                    }
                }
            }
        }
    }
}
