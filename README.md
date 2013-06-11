

ikrs.json
=========

This is a tiny JSON parser (and builder) written in Java.


Basic JSON datatypes are included:
 - JSONBoolean
 - JSONNumber
 - JSONString
 - JSONArray
 - JSONObject
 - JSONNull



Example call:
-------------
$ java ikrs.json.JSONBuilder test.json.txt
Initialising reader ... 
Initialising parser/builder ... 
Starting the parser ...
Closing the reader ...
Done.
Parsing and building took 14 ms.
JSON object: {age=2630, answer_is_correct=false, error=this might be an error message., floating_value_0=0.0, floating_value_1=1.0, floating_value_2=1.3E23, mixed_array_and_object=[A, B, {X=[d, e]}, F], my_array=[], my_array_2=[1, 2, 3], my_array_3=[1, false, {name=null}, true], my_parser_also_ignores_the_case=true, name=test, negative_float=-3.14159265359, negative_number=-23, nested_array_0=[1, [2, [3, 4, 5], 6]], nested_object_0={a=1, b={c=2, d={e=4, f=5}}, f=6}, object_0={a=1, b=2, c=3, d=4}, question_expired=true, status=111, test_A=A line- 
n -break, test_C=An unicode Å character (should be the danish Ao), test_x=false, test_y=testing, user_exists=true}
