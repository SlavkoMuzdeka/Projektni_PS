use projektni_ps;

delimiter $$
create procedure create_child(
	in jmb char(13),
	   ime varchar(50),
       prezime varchar(50),
       datumRodjenja DATE,
       ulica varchar(100),
       grad varchar(100),
       brojUlice INT, 
       visina INT,
       tezina INT,
       dokument LONGBLOB,
	out kreiran_status bool
)
begin
	declare idO, idA INT;
    set kreiran_status = false;
    
    insert into adresa(Ulica,Grad,Broj) values (ulica, grad, brojUlice);
    select LAST_INSERT_ID() into idA;
    
    insert into osoba(JMB,Ime,Prezime,DatumRodjenja,ADRESA_IdAdrese) values (jmb, ime, prezime, datumRodjenja, idA);
    select LAST_INSERT_ID() into idO;
    
    insert into dijete values(idO, visina, tezina);
    
    insert into ljekarsko_uvjerenje(VASPITAC_OSOBA_IdOsobe, DIJETE_OSOBA_IdOsobe, Dokument) values (null, idO, dokument);
    set kreiran_status = true;
    
end$$
delimiter ;