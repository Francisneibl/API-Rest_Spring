select round(avg(c.classification)::numeric, 0) as media, m.* from movie as m, classification as c
where m.id = c.fk_movie
group by m.id;
