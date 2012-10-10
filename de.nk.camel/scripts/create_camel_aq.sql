/*
-- role for AQ admin user
create role camel_aq_admin_role;
grant connect, resource, aq_administrator_role, create any procedure to camel_aq_admin_role;

-- role for AQ user
create role camel_aq_user_role;
grant create session, aq_user_role to camel_aq_user_role;

-- rights for sending messages into a queue
exec dbms_aqadm.grant_system_privilege(privilege => 'ENQUEUE_ANY', grantee => 'camel_aq_user_role', admin_option => true);

-- rights for receiving/dequeuing messages from a queue
exec dbms_aqadm.grant_system_privilege(privilege => 'DEQUEUE_ANY', grantee => 'camel_aq_user_role', admin_option => true);

-- create admin user for queues
create user camel_aq_admin identified by camelaq;
grant camel_aq_admin_role to camel_aq_admin;
grant execute on dbms_aq to camel_aq_admin;

-- create user for queues
create user camel_aq_user identified by camelaq;
grant connect, resource, create session to camel_aq_user;
grant camel_aq_user_role to camel_aq_user;
grant execute on dbms_aq to camel_aq_user;
*/

-- create queue(s)
exec dbms_aqadm.create_queue_table(queue_table => 'CAMEL_IN_T', queue_payload_type => 'SYS.AQ$_JMS_TEXT_MESSAGE', multiple_consumers => false);
exec dbms_aqadm.create_queue(queue_name => 'CAMEL_IN', queue_table => 'CAMEL_IN_T');
exec dbms_aqadm.start_queue(queue_name => 'CAMEL_IN');

exec dbms_aqadm.create_queue_table(queue_table => 'CAMEL_OUT_T', queue_payload_type => 'SYS.AQ$_JMS_TEXT_MESSAGE', multiple_consumers => false);
exec dbms_aqadm.create_queue(queue_name => 'CAMEL_OUT', queue_table => 'CAMEL_OUT_T');
exec dbms_aqadm.start_queue(queue_name => 'CAMEL_OUT');

/*
-- grant the camel_aq_user_role the needed rights to inserts and modify
grant select, delete, insert, update on camel_in_t to camel_aq_user_role;
grant select, delete, insert, update on camel_out_t to camel_aq_user_role;
*/
commit;

create table camel_demo (
  id number,
  message varchar2(80 byte),
  datetime date
  );

commit;