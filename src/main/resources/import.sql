insert into department (id, name, location) values (-1, 'Softwareentwicklung', 'Leonding');
insert into department (id, name, location) values (-2, 'Design', 'Marchtrenk');
insert into department (id, name, location) values (-3, 'Marketing', 'Linz');

insert into employee (id, firstname, lastname, department_id, manager_id) values (-1, 'Marvin', 'Aichinger', -1, null);
insert into employee (id, firstname, lastname, department_id, manager_id) values (-2, 'Simon', 'Kletsch', -1, -1);
insert into employee (id, firstname, lastname, department_id, manager_id) values (-3, 'Felix', 'Fuchshuber', -2, -1);
insert into employee (id, firstname, lastname, department_id, manager_id) values (-4, 'Lara', 'Pichler', -3, -1);
insert into employee (id, firstname, lastname, department_id, manager_id) values (-5, 'Florian', 'Doppler', -2, -1);
insert into employee (id, firstname, lastname, department_id, manager_id) values (-6, 'Maxi', 'Eder', -1, -1);
insert into employee (id, firstname, lastname, department_id, manager_id) values (-7, 'Sarah', 'Reichl', -3, -4);
insert into employee (id, firstname, lastname, department_id, manager_id) values (-8, 'Teresa', 'Holzer', -3, -4);