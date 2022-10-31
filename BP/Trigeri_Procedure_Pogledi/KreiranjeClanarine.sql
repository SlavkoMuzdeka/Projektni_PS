use projektni_ps;

delimiter $$
create procedure create_clanarina(
	in id_djeteta INT,
       tipUsluge varchar(30),
       iznos INT,
       mjesec DATE,
	out je_kreirana bool
)
begin
	set je_kreirana = false;
	insert into clanarina(TipUsluge,Iznos,Placeno,Datum,DIJETE_OSOBA_IdOsobe,DatumPlacanja) values (tipUsluge,iznos,0,mjesec,id_djeteta,null);
	set je_kreirana = true;
end$$
delimiter ;

drop procedure create_clanarina;
