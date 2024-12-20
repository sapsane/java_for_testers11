package ru.stqa.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stqa.addressbook.common.CommonFunctions;
import ru.stqa.addressbook.model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {


    public static List<GroupData> groupProvider() throws IOException {
        var result= new ArrayList<GroupData>();
               // new GroupData(),
              //  new GroupData().withName("Test some"),
              //  new GroupData("Group1 name","",""),
             //   new GroupData("Group2 name'","","")));
//        for(var name : List.of("","Group1 name")){
//            for(var header : List.of("","header name1")){
//                for (var footer : List.of("","footer name1")){
//                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
//                }
//            }
//        }

//        for(int i=0; i<5; i++){
//            result.add(new GroupData()
//                    .withName(CommonFunctions.randomString(i*10))
//                    .withHeader(CommonFunctions.randomString(i*10))
//                    .withFooter(CommonFunctions.randomString(i*10)) );
//        }
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(new File("groups.json"), new TypeReference<List<GroupData>>() {});
        result.addAll(value);
        return result;
    }



    public static List<GroupData> negativeGroupProvider() {
        var result= new ArrayList<GroupData>(List.of(
                new GroupData("", "Group2 name'","","")));

        return result;
    }
/*
    @ParameterizedTest
    @ValueSource(strings={"Group1 name","Group2 name'"})
    public void canCreateGroup(String name) {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(new GroupData( name, "Group header", "Group footer") );
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount+1,newGroupCount);
    }

 */

/*
    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData() );
    }

 */
/*
    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("Test some") );
    }


 */
    public static List<GroupData> singleRandomGroup()  {
       return List.of(new GroupData()
                .withName(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(20))
                .withFooter(CommonFunctions.randomString(30)));
    }



    @ParameterizedTest
    @MethodSource("singleRandomGroup")
    public void canCreateGroup(GroupData group) {

//        var oldGroups = app.groups().getList();
        var oldGroups = app.hbm().getGroupList();
        app.groups().createGroup(group);
        var newGroups = app.hbm().getGroupList();

        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        var maxId = newGroups.get(newGroups.size()-1).id();

        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups,expectedList);
    }




    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupData group) {
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
        Assertions.assertEquals(newGroups,oldGroups);
    }

}
