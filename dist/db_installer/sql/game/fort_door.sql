-- ---------------------------
-- Table structure for fort_door
-- ---------------------------
DROP TABLE IF EXISTS fort_door;
CREATE TABLE fort_door (
  fortId INT NOT NULL default 0,
  id INT NOT NULL default 0,
  name varchar(30) NOT NULL,
  x INT NOT NULL default 0,
  y INT NOT NULL default 0,
  z INT NOT NULL default 0,
  range_xmin INT NOT NULL default 0,
  range_ymin INT NOT NULL default 0,
  range_zmin INT NOT NULL default 0,
  range_xmax INT NOT NULL default 0,
  range_ymax INT NOT NULL default 0,
  range_zmax INT NOT NULL default 0,
  hp INT NOT NULL default 0,
  pDef INT NOT NULL default 0,
  mDef INT NOT NULL default 0,
  PRIMARY KEY(id),
  KEY id (fortId)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `fort_door` VALUES 
(101,18220001,'Gate_of_fort',-50796,155913,-2102,0,0,0,0,0,0,67884,644,518),
(101,18220002,'Gate_of_fort',-53359,156592,-2081,0,0,0,0,0,0,67884,644,518),
(101,18220003,'Gate_of_fort',-53313,156743,-2081,0,0,0,0,0,0,67884,644,518),
(101,18220004,'Gate_of_fort',-52211,156244,-2081,0,0,0,0,0,0,67884,644,518),
(101,18220005,'Gate_of_fort',-52165,156395,-2081,0,0,0,0,0,0,67884,644,518),
(101,18220006,'Gate_of_fort',-52817,157874,-2053,0,0,0,0,0,0,67884,644,518),
(101,18220007,'Gate_of_fort',-52771,158025,-2053,0,0,0,0,0,0,67884,644,518),
(101,18220008,'Gate_of_fort',-54738,157112,-2102,0,0,0,0,0,0,67884,644,518),
(102,19240001,'Gate_of_fort',-22326,218062,-3237,0,0,0,0,0,0,67884,644,518),
(102,19240002,'Gate_of_fort',-22326,218220,-3237,0,0,0,0,0,0,67884,644,518),
(102,19240003,'Gate_of_fort',-23550,218784,-3263,0,0,0,0,0,0,67884,644,518),
(102,19240004,'Gate_of_fort',-23550,218940,-3263,0,0,0,0,0,0,67884,644,518),
(102,19240005,'Gate_of_fort',-25126,219880,-3291,0,0,0,0,0,0,67884,644,518),
(102,19240006,'Gate_of_fort',-22106,219722,-3264,0,0,0,0,0,0,67884,644,518),
(102,19240007,'Gate_of_fort',-22106,219880,-3264,0,0,0,0,0,0,67884,644,518),
(102,19240008,'Gate_of_fort',-23305,219722,-3264,0,0,0,0,0,0,67884,644,518),
(102,19240009,'Gate_of_fort',-23305,219880,-3264,0,0,0,0,0,0,67884,644,518),
(102,19240010,'Gate_of_fort',-20241,219888,-3288,0,0,0,0,0,0,67884,644,518),
(102,19240011,'Gate_of_fort',-23211,221582,-3227,0,0,0,0,0,0,67884,644,518),
(102,19240012,'Gate_of_fort',-23211,221740,-3227,0,0,0,0,0,0,67884,644,518),
(103,20230003,'Gate_of_fort',15546,186351,-2972,0,0,0,0,0,0,67884,644,518),
(103,20230004,'Gate_of_fort',16180,187607,-2952,0,0,0,0,0,0,67884,644,518),
(103,20230005,'Gate_of_fort',16312,187520,-2952,0,0,0,0,0,0,67884,644,518),
(103,20230006,'Gate_of_fort',17540,187015,-2923,0,0,0,0,0,0,67884,644,518),
(103,20230007,'Gate_of_fort',17670,186928,-2923,0,0,0,0,0,0,67884,644,518),
(103,20230008,'Gate_of_fort',16848,188606,-2952,0,0,0,0,0,0,67884,644,518),
(103,20230009,'Gate_of_fort',16979,188518,-2952,0,0,0,0,0,0,67884,644,518),
(103,20230010,'Gate_of_fort',17826,189764,-2972,0,0,0,0,0,0,67884,644,518),
(104,23210001,'Gate_of_fort',126069,120674,-2634,0,0,0,0,0,0,67884,644,518),
(104,23210002,'Gate_of_fort',126760,121726,-2613,0,0,0,0,0,0,67884,644,518),
(104,23210003,'Gate_of_fort',126760,121884,-2613,0,0,0,0,0,0,67884,644,518),
(104,23210004,'Gate_of_fort',124224,122888,-2583,0,0,0,0,0,0,67884,644,518),
(104,23210005,'Gate_of_fort',124382,122888,-2583,0,0,0,0,0,0,67884,644,518),
(104,23210006,'Gate_of_fort',126000,123942,-2613,0,0,0,0,0,0,67884,644,518),
(104,23210007,'Gate_of_fort',126158,123942,-2613,0,0,0,0,0,0,67884,644,518),
(104,23210008,'Gate_of_fort',127569,123334,-2571,0,0,0,0,0,0,67884,644,518),
(104,23210009,'Gate_of_fort',127569,123492,-2571,0,0,0,0,0,0,67884,644,518),
(104,23210010,'Gate_of_fort',126000,122744,-2613,0,0,0,0,0,0,67884,644,518),
(104,23210011,'Gate_of_fort',126158,122744,-2613,0,0,0,0,0,0,67884,644,518),
(104,23210012,'Gate_of_fort',126066,125563,-2634,0,0,0,0,0,0,67884,644,518),
(105,22180001,'Gate_of_fort',74199,2788,-3093,0,0,0,0,0,0,67884,644,518),
(105,22180002,'Gate_of_fort',72418,4689,-3073,0,0,0,0,0,0,67884,644,518),
(105,22180003,'Gate_of_fort',72540,4790,-3073,0,0,0,0,0,0,67884,644,518),
(105,22180004,'Gate_of_fort',73178,3764,-3073,0,0,0,0,0,0,67884,644,518),
(105,22180005,'Gate_of_fort',73300,3864,-3073,0,0,0,0,0,0,67884,644,518),
(105,22180006,'Gate_of_fort',74141,4890,-3044,0,0,0,0,0,0,67884,644,518),
(105,22180007,'Gate_of_fort',74263,4990,-3044,0,0,0,0,0,0,67884,644,518),
(105,22180008,'Gate_of_fort',71596,5960,-3093,0,0,0,0,0,0,67884,644,518),
(106,24190005,'Gate_of_fort',153328,56710,-3303,0,0,0,0,0,0,67884,644,518),
(106,24190006,'Gate_of_fort',155311,54864,-3282,0,0,0,0,0,0,67884,644,518),
(106,24190007,'Gate_of_fort',155411,54986,-3282,0,0,0,0,0,0,67884,644,518),
(106,24190008,'Gate_of_fort',154384,55624,-3282,0,0,0,0,0,0,67884,644,518),
(106,24190009,'Gate_of_fort',154484,55746,-3282,0,0,0,0,0,0,67884,644,518),
(106,24190010,'Gate_of_fort',156501,54106,-3303,0,0,0,0,0,0,67884,644,518),
(106,24190011,'Gate_of_fort',156035,56156,-3253,0,0,0,0,0,0,67884,644,518),
(106,24190012,'Gate_of_fort',156135,56278,-3253,0,0,0,0,0,0,67884,644,518),
(107,25190001,'Gate_of_fort',189904,37070,-3460,0,0,0,0,0,0,67884,644,518),
(107,25190002,'Gate_of_fort',190612,38122,-3443,0,0,0,0,0,0,67884,644,518),
(107,25190003,'Gate_of_fort',190612,38280,-3443,0,0,0,0,0,0,67884,644,518),
(107,25190004,'Gate_of_fort',188076,39284,-3409,0,0,0,0,0,0,67884,644,518),
(107,25190005,'Gate_of_fort',188234,39284,-3409,0,0,0,0,0,0,67884,644,518),
(107,25190006,'Gate_of_fort',189852,40340,-3438,0,0,0,0,0,0,67884,644,518),
(107,25190007,'Gate_of_fort',190010,40340,-3438,0,0,0,0,0,0,67884,644,518),
(107,25190008,'Gate_of_fort',189852,39139,-3438,0,0,0,0,0,0,67884,644,518),
(107,25190009,'Gate_of_fort',190010,39139,-3438,0,0,0,0,0,0,67884,644,518),
(107,25190010,'Gate_of_fort',191421,39730,-3397,0,0,0,0,0,0,67884,644,518),
(107,25190011,'Gate_of_fort',191421,39888,-3397,0,0,0,0,0,0,67884,644,518),
(107,25190012,'Gate_of_fort',189913,41955,-3460,0,0,0,0,0,0,67884,644,518),
(108,23240001,'Gate_of_fort',116614,203941,-3382,0,0,0,0,0,0,67884,644,518),
(108,23240002,'Gate_of_fort',118905,205272,-3361,0,0,0,0,0,0,67884,644,518),
(108,23240003,'Gate_of_fort',118979,205133,-3361,0,0,0,0,0,0,67884,644,518),
(108,23240004,'Gate_of_fort',119430,203983,-3333,0,0,0,0,0,0,67884,644,518),
(108,23240005,'Gate_of_fort',119504,203843,-3333,0,0,0,0,0,0,67884,644,518),
(108,23240006,'Gate_of_fort',117847,204708,-3361,0,0,0,0,0,0,67884,644,518),
(108,23240007,'Gate_of_fort',117922,204568,-3361,0,0,0,0,0,0,67884,644,518),
(108,23240008,'Gate_of_fort',120248,205879,-3382,0,0,0,0,0,0,67884,644,518),
(109,24150001,'Gate_of_fort',158498,-72104,-2865,0,0,0,0,0,0,67884,644,518),
(109,24150002,'Gate_of_fort',158585,-71973,-2865,0,0,0,0,0,0,67884,644,518),
(109,24150003,'Gate_of_fort',157297,-69092,-2916,0,0,0,0,0,0,67884,644,518),
(109,24150004,'Gate_of_fort',159605,-70707,-2892,0,0,0,0,0,0,67884,644,518),
(109,24150005,'Gate_of_fort',159693,-70576,-2892,0,0,0,0,0,0,67884,644,518),
(109,24150006,'Gate_of_fort',158606,-70040,-2892,0,0,0,0,0,0,67884,644,518),
(109,24150007,'Gate_of_fort',158694,-69909,-2892,0,0,0,0,0,0,67884,644,518),
(109,24150008,'Gate_of_fort',161354,-71814,-2916,0,0,0,0,0,0,67884,644,518),
(109,24150009,'Gate_of_fort',160742,-70553,-2899,0,0,0,0,0,0,67884,644,518),
(109,24150010,'Gate_of_fort',160872,-70640,-2899,0,0,0,0,0,0,67884,644,518),
(109,24150011,'Gate_of_fort',159854,-68987,-2853,0,0,0,0,0,0,67884,644,518),
(109,24150012,'Gate_of_fort',159985,-69075,-2853,0,0,0,0,0,0,67884,644,518),
(110,22160001,'Gate_of_fort',68834,-63635,-2834,0,0,0,0,0,0,67884,644,518),
(110,22160002,'Gate_of_fort',68643,-62607,-2814,0,0,0,0,0,0,67884,644,518),
(110,22160003,'Gate_of_fort',68703,-62461,-2814,0,0,0,0,0,0,67884,644,518),
(110,22160004,'Gate_of_fort',69991,-60842,-2814,0,0,0,0,0,0,67884,644,518),
(110,22160005,'Gate_of_fort',70137,-60902,-2814,0,0,0,0,0,0,67884,644,518),
(110,22160006,'Gate_of_fort',67849,-61153,-2776,0,0,0,0,0,0,67884,644,518),
(110,22160007,'Gate_of_fort',67995,-61214,-2776,0,0,0,0,0,0,67884,644,518),
(110,22160008,'Gate_of_fort',69532,-61951,-2814,0,0,0,0,0,0,67884,644,518),
(110,22160009,'Gate_of_fort',69678,-62012,-2814,0,0,0,0,0,0,67884,644,518),
(110,22160010,'Gate_of_fort',71440,-61683,-2786,0,0,0,0,0,0,67884,644,518),
(110,22160011,'Gate_of_fort',71586,-61743,-2786,0,0,0,0,0,0,67884,644,518),
(110,22160012,'Gate_of_fort',70698,-59119,-2834,0,0,0,0,0,0,67884,644,518),
(111,23130001,'Gate_of_fort',107495,-140524,-3009,0,0,0,0,0,0,67884,644,518),
(111,23130002,'Gate_of_fort',110037,-141474,-2984,0,0,0,0,0,0,67884,644,518),
(111,23130003,'Gate_of_fort',110083,-141323,-2984,0,0,0,0,0,0,67884,644,518),
(111,23130004,'Gate_of_fort',108889,-141126,-2984,0,0,0,0,0,0,67884,644,518),
(111,23130005,'Gate_of_fort',108935,-140975,-2984,0,0,0,0,0,0,67884,644,518),
(111,23130006,'Gate_of_fort',111423,-141714,-3009,0,0,0,0,0,0,67884,644,518),
(111,23130007,'Gate_of_fort',110210,-140001,-2959,0,0,0,0,0,0,67884,644,518),
(111,23130008,'Gate_of_fort',110255,-139851,-2959,0,0,0,0,0,0,67884,644,518),
(112,20220017,'Gate_of_fort',4738,147966,-2918,0,0,0,0,0,0,67884,644,518),
(112,20220018,'Gate_of_fort',4896,147966,-2918,0,0,0,0,0,0,67884,644,518),
(112,20220019,'Gate_of_fort',6381,148169,-2889,0,0,0,0,0,0,67884,644,518),
(112,20220020,'Gate_of_fort',6381,148327,-2889,0,0,0,0,0,0,67884,644,518),
(112,20220021,'Gate_of_fort',4016,148732,-2938,0,0,0,0,0,0,67884,644,518),
(112,20220022,'Gate_of_fort',6212,149673,-2917,0,0,0,0,0,0,67884,644,518),
(112,20220023,'Gate_of_fort',6212,149831,-2917,0,0,0,0,0,0,67884,644,518),
(112,20220024,'Gate_of_fort',5011,149673,-2917,0,0,0,0,0,0,67884,644,518),
(112,20220025,'Gate_of_fort',5011,149831,-2917,0,0,0,0,0,0,67884,644,518),
(112,20220026,'Gate_of_fort',7439,150734,-2938,0,0,0,0,0,0,67884,644,518),
(112,20220027,'Gate_of_fort',5135,151876,-2879,0,0,0,0,0,0,67884,644,518),
(112,20220028,'Gate_of_fort',5293,151876,-2879,0,0,0,0,0,0,67884,644,518),
(113,18200001,'Gate_of_fort',-54247,89585,-2870,0,0,0,0,0,0,67884,644,518),
(113,18200002,'Gate_of_fort',-53312,91823,-2849,0,0,0,0,0,0,67884,644,518),
(113,18200003,'Gate_of_fort',-53154,91823,-2849,0,0,0,0,0,0,67884,644,518),
(113,18200004,'Gate_of_fort',-51513,90259,-2851,0,0,0,0,0,0,67884,644,518),
(113,18200005,'Gate_of_fort',-51513,90417,-2851,0,0,0,0,0,0,67884,644,518),
(113,18200006,'Gate_of_fort',-55123,91775,-2819,0,0,0,0,0,0,67884,644,518),
(113,18200007,'Gate_of_fort',-55123,91933,-2819,0,0,0,0,0,0,67884,644,518),
(113,18200008,'Gate_of_fort',-51146,91961,-2811,0,0,0,0,0,0,67884,644,518),
(113,18200009,'Gate_of_fort',-51259,92074,-2811,0,0,0,0,0,0,67884,644,518),
(113,18200010,'Gate_of_fort',-52256,92985,-2869,0,0,0,0,0,0,67884,644,518),
(113,18200011,'Gate_of_fort',-53318,90621,-2849,0,0,0,0,0,0,67884,644,518),
(113,18200012,'Gate_of_fort',-53160,90621,-2849,0,0,0,0,0,0,67884,644,518),
(114,21220001,'Gate_of_fort',58984,138135,-1803,0,0,0,0,0,0,67884,644,518),
(114,21220002,'Gate_of_fort',60320,140038,-1782,0,0,0,0,0,0,67884,644,518),
(114,21220003,'Gate_of_fort',60474,140007,-1782,0,0,0,0,0,0,67884,644,518),
(114,21220004,'Gate_of_fort',61655,138596,-1754,0,0,0,0,0,0,67884,644,518),
(114,21220005,'Gate_of_fort',61809,138565,-1754,0,0,0,0,0,0,67884,644,518),
(114,21220006,'Gate_of_fort',60086,138864,-1782,0,0,0,0,0,0,67884,644,518),
(114,21220007,'Gate_of_fort',60240,138833,-1782,0,0,0,0,0,0,67884,644,518),
(114,21220008,'Gate_of_fort',61544,140749,-1803,0,0,0,0,0,0,67884,644,518),
(115,20200001,'Gate_of_fort',12496,93487,-3429,0,0,0,0,0,0,158250,644,518),
(115,20200002,'Gate_of_fort',11467,94385,-3426,0,0,0,0,0,0,158250,644,518),
(115,20200003,'Gate_of_fort',11605,94374,-3426,0,0,0,0,0,0,158250,644,518),
(115,20200004,'Gate_of_fort',10126,94940,-3399,0,0,0,0,0,0,158250,644,518),
(115,20200005,'Gate_of_fort',10124,95088,-3399,0,0,0,0,0,0,158250,644,518),
(115,20200006,'Gate_of_fort',11466,95581,-3426,0,0,0,0,0,0,158250,644,518),
(115,20200007,'Gate_of_fort',11610,95585,-3426,0,0,0,0,0,0,158250,644,518),
(115,20200008,'Gate_of_fort',10476,96573,-3429,0,0,0,0,0,0,158250,644,518),
(116,22200001,'Gate_of_fort',78090,89321,-2934,0,0,0,0,0,0,67884,644,518),
(116,22200002,'Gate_of_fort',80522,89326,-2877,0,0,0,0,0,0,67884,644,518),
(116,22200003,'Gate_of_fort',80661,89401,-2877,0,0,0,0,0,0,67884,644,518),
(116,22200004,'Gate_of_fort',79730,91401,-2912,0,0,0,0,0,0,67884,644,518),
(116,22200005,'Gate_of_fort',79804,91262,-2912,0,0,0,0,0,0,67884,644,518),
(116,22200006,'Gate_of_fort',78673,90835,-2912,0,0,0,0,0,0,67884,644,518),
(116,22200007,'Gate_of_fort',78747,90696,-2912,0,0,0,0,0,0,67884,644,518),
(116,22200008,'Gate_of_fort',77815,92082,-2887,0,0,0,0,0,0,67884,644,518),
(116,22200009,'Gate_of_fort',77889,91943,-2887,0,0,0,0,0,0,67884,644,518),
(116,22200010,'Gate_of_fort',79034,92957,-2916,0,0,0,0,0,0,67884,644,518),
(116,22200011,'Gate_of_fort',79172,93030,-2916,0,0,0,0,0,0,67884,644,518),
(116,22200012,'Gate_of_fort',80167,92700,-2934,0,0,0,0,0,0,67884,644,518),
(117,23170001,'Gate_of_fort',112349,-16973,-1045,0,0,0,0,0,0,67884,644,518),
(117,23170002,'Gate_of_fort',109785,-15919,-995,0,0,0,0,0,0,67884,644,518),
(117,23170003,'Gate_of_fort',109943,-15919,-995,0,0,0,0,0,0,67884,644,518),
(117,23170004,'Gate_of_fort',111289,-14550,-1023,0,0,0,0,0,0,67884,644,518),
(117,23170005,'Gate_of_fort',111447,-14550,-1023,0,0,0,0,0,0,67884,644,518),
(117,23170006,'Gate_of_fort',109582,-14432,-1024,0,0,0,0,0,0,67884,644,518),
(117,23170007,'Gate_of_fort',109582,-14274,-1024,0,0,0,0,0,0,67884,644,518),
(117,23170008,'Gate_of_fort',111289,-15750,-1023,0,0,0,0,0,0,67884,644,518),
(117,23170009,'Gate_of_fort',111447,-15750,-1023,0,0,0,0,0,0,67884,644,518),
(117,23170010,'Gate_of_fort',113492,-14829,-987,0,0,0,0,0,0,67884,644,518),
(117,23170011,'Gate_of_fort',113492,-14673,-987,0,0,0,0,0,0,67884,644,518),
(117,23170012,'Gate_of_fort',110348,-13549,-1047,0,0,0,0,0,0,67884,644,518),
(118,23200001,'Gate_of_fort',124213,93493,-2191,0,0,0,0,0,0,67884,644,518),
(118,23200002,'Gate_of_fort',125167,95734,-2168,0,0,0,0,0,0,67884,644,518),
(118,23200003,'Gate_of_fort',125325,95734,-2168,0,0,0,0,0,0,67884,644,518),
(118,23200004,'Gate_of_fort',126966,94171,-2170,0,0,0,0,0,0,67884,644,518),
(118,23200005,'Gate_of_fort',126966,94329,-2170,0,0,0,0,0,0,67884,644,518),
(118,23200006,'Gate_of_fort',123356,95687,-2138,0,0,0,0,0,0,67884,644,518),
(118,23200007,'Gate_of_fort',123356,95845,-2138,0,0,0,0,0,0,67884,644,518),
(118,23200008,'Gate_of_fort',125167,94534,-2168,0,0,0,0,0,0,67884,644,518),
(118,23200009,'Gate_of_fort',125325,94534,-2168,0,0,0,0,0,0,67884,644,518),
(118,23200010,'Gate_of_fort',127221,95985,-2130,0,0,0,0,0,0,67884,644,518),
(118,23200011,'Gate_of_fort',127332,95873,-2130,0,0,0,0,0,0,67884,644,518),
(118,23200012,'Gate_of_fort',126193,96897,-2190,0,0,0,0,0,0,67884,644,518),
(119,22230001,'Gate_of_fort',73057,184177,-2630,0,0,0,0,0,0,67884,644,518),
(119,22230002,'Gate_of_fort',71908,185170,-2581,0,0,0,0,0,0,67884,644,518),
(119,22230003,'Gate_of_fort',71996,185039,-2581,0,0,0,0,0,0,67884,644,518),
(119,22230004,'Gate_of_fort',72714,186440,-2609,0,0,0,0,0,0,67884,644,518),
(119,22230005,'Gate_of_fort',72846,186528,-2609,0,0,0,0,0,0,67884,644,518),
(119,22230006,'Gate_of_fort',73381,185443,-2609,0,0,0,0,0,0,67884,644,518),
(119,22230007,'Gate_of_fort',73512,185531,-2609,0,0,0,0,0,0,67884,644,518),
(119,22230008,'Gate_of_fort',73037,187834,-2630,0,0,0,0,0,0,67884,644,518),
(120,23160001,'Gate_of_fort',99133,-56363,-693,0,0,0,0,0,0,67884,644,518),
(120,23160002,'Gate_of_fort',100609,-56729,-645,0,0,0,0,0,0,67884,644,518),
(120,23160003,'Gate_of_fort',100767,-56727,-645,0,0,0,0,0,0,67884,644,518),
(120,23160004,'Gate_of_fort',101315,-55398,-673,0,0,0,0,0,0,67884,644,518),
(120,23160005,'Gate_of_fort',101315,-55240,-673,0,0,0,0,0,0,67884,644,518),
(120,23160006,'Gate_of_fort',100114,-55398,-673,0,0,0,0,0,0,67884,644,518),
(120,23160007,'Gate_of_fort',100114,-55241,-673,0,0,0,0,0,0,67884,644,518),
(120,23160008,'Gate_of_fort',102190,-54353,-695,0,0,0,0,0,0,67884,644,518),
(121,22150001,'Gate_of_fort',72491,-96493,-1478,0,0,0,0,0,0,67884,644,518),
(121,22150002,'Gate_of_fort',72324,-94183,-1456,0,0,0,0,0,0,67884,644,518),
(121,22150003,'Gate_of_fort',72470,-94243,-1456,0,0,0,0,0,0,67884,644,518),
(121,22150004,'Gate_of_fort',70847,-94274,-1428,0,0,0,0,0,0,67884,644,518),
(121,22150005,'Gate_of_fort',70907,-94128,-1428,0,0,0,0,0,0,67884,644,518),
(121,22150006,'Gate_of_fort',71864,-95290,-1456,0,0,0,0,0,0,67884,644,518),
(121,22150007,'Gate_of_fort',72010,-95351,-1456,0,0,0,0,0,0,67884,644,518),
(121,22150008,'Gate_of_fort',71795,-92905,-1477,0,0,0,0,0,0,67884,644,518);