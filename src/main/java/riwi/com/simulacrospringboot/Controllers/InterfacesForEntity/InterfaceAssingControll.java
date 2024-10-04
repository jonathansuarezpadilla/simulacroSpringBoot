package riwi.com.simulacrospringboot.Controllers.InterfacesForEntity;

import riwi.com.simulacrospringboot.Controllers.GenericMethods.AssignAbility;
import riwi.com.simulacrospringboot.Controllers.GenericMethods.AssingAbilityMission;
import riwi.com.simulacrospringboot.Controllers.GenericMethods.AssingMision;


public interface InterfaceAssingControll extends
        AssingMision<String>
        ,AssignAbility<String>,
        AssingAbilityMission<String> {
}
