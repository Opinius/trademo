insert into object_types (name) values ('independent');
insert into object_types (name) values ('rigging');

insert into factory_objects (type_id, subtype, name, attributes)
values ((select id from object_types where name = 'independent'), 'table', 'Basic table', '{"length":1000, "width":800, "height":200, "carrying": 100}');

insert into factory_objects (type_id, subtype, name, attributes)
values ((select id from object_types where name = 'independent'), 'robot', 'Robotic manipulator KUKA KR210', '{"carrying": 210}');

insert into factory_objects (type_id, subtype, name, attributes)
values ((select id from object_types where name = 'rigging'), 'sensor', 'Force sensor ATI Axia80-M20', '{"measuringRange": 900, "direction": "z"}');

insert into factory_objects (type_id, subtype, name, attributes)
values ((select id from object_types where name = 'rigging'), 'gripper', 'Two finger gripper Schunk PGN-100', '{"length":100, "width":250, "height":50}');
