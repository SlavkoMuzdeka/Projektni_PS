use projektni_ps;

delimiter $$
create procedure create_child(
	in ime char(13),
	   prezime varchar(50),
       jmb varchar(50),
       ime_oca varchar(50),
       ime_majke varchar(50),
       datum_rodjenja DATE,
       grad varchar(50),
       ulica varchar(50),
       broj INT,
       broj_telefona_oca varchar(20),
       broj_telefona_majke varchar(20),
       visina INT,
       tezina INT,
       dokument LONGBLOB,
	out kreiran_status bool
)
begin

	declare idO, idA, broj_takvih_adresa INT;
    set kreiran_status = false;
    
    select count(*) into broj_takvih_adresa
    from adresa
    where Ulica = ulica and Grad = grad and Broj = broj;
    
    if broj_takvih_adresa > 0 then
		select IdAdrese into idA
        from adresa
        where Ulica = ulica and Grad = grad and Broj = broj;
    else
		insert into adresa(Ulica,Grad,Broj) values (ulica, grad, brojUlice);
		select LAST_INSERT_ID() into idA;
    end if;
    
    insert into osoba(JMB,Ime,Prezime,DatumRodjenja,ADRESA_IdAdrese) values (jmb, ime, prezime, datumRodjenja, idA);
    select LAST_INSERT_ID() into idO;
    
    insert into dijete values(idO, visina, tezina, ime_oca, ime_majke, broj_telefona_oca, broj_telefona_majke, 0);
    
    insert into ljekarsko_uvjerenje(VASPITAC_OSOBA_IdOsobe, DIJETE_OSOBA_IdOsobe, Dokument) values (null, idO, dokument);
    set kreiran_status = true;
    
end$$
delimiter ;