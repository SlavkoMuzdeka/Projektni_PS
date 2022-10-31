use projektni_ps;

delimiter $$
create procedure add_person_to_group (
	in id_osobe INT, 
	   id_grupe INT,
       tip_osobe bool,
       period INT,
	out je_dodana bool
)
begin
	set je_dodana = false;
    
    if tip_osobe = 1 then
		insert into vaspitac_has_grupa values (id_osobe, id_grupe, DATE(NOW()), period);
        set je_dodana = true;
	else
		insert into dijete_has_grupa values (id_osobe, id_grupe, DATE(NOW()), period);
        set je_dodana = true;
	end if;


end$$
delimiter ;
