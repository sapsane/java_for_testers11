package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;

public class GroupCreationTests extends TestBase {


    public static List<GroupData> groupProvider() {
        var result= new ArrayList<GroupData>();
               // new GroupData(),
              //  new GroupData().withName("Test some"),
              //  new GroupData("Group1 name","",""),
             //   new GroupData("Group2 name'","","")));
        for(var name : List.of("","Group1 name")){
            for(var header : List.of("","header name1")){
                for (var footer : List.of("","footer name1")){
                    result.add(new GroupData(name,header,footer));
                }
            }
        }

        for(int i=0; i<5; i++){
            result.add(new GroupData( randomString(i*10),randomString(i*10),randomString(i*10) ));
        }
        return result;
    }



    public static List<GroupData> negativeGroupProvider() {
        var result= new ArrayList<GroupData>(List.of(
                new GroupData("Group2 name'","","")));

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
    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroups(GroupData group) {

        int groupCount = app.groups().getCount();
        app.groups().createGroup(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount+1,newGroupCount);
    }
    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupData group) {

        int groupCount = app.groups().getCount();
        app.groups().createGroup(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount,newGroupCount);
    }

}
