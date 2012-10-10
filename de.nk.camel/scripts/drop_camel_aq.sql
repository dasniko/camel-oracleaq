drop role camel_aq_admin_role;
drop role camel_aq_user_role;
drop user camel_aq_admin;
drop user camel_aq_user;

exec dbms_aqadm.stop_queue(queue_name => 'CAMEL_IN');
exec dbms_aqadm.drop_queue(queue_name => 'CAMEL_IN');
exec dbms_aqadm.drop_queue_table(queue_table => 'CAMEL_IN_T');

exec dbms_aqadm.stop_queue(queue_name => 'CAMEL_OUT');
exec dbms_aqadm.drop_queue(queue_name => 'CAMEL_OUT');
exec dbms_aqadm.drop_queue_table(queue_table => 'CAMEL_OUT_T');

commit;

drop table CAMEL_DEMO;
commit;