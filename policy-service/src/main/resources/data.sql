SET SCHEMA "CLAIM";

INSERT INTO "CLAIM"."MEMBERS"
VALUES (
  101, 
  'ANIKET', 
  'DAS', 
  22, 
  'MALE', 
  '1999-01-13', 
  'PARK STREET, KOLKATA'
);
INSERT INTO "CLAIM"."MEMBERS"
VALUES (
  102, 
  'SIMRAN', 
  'KAUR', 
  23, 
  'FEMALE', 
  '1998-04-01', 
  'SOUTHERN AVENUE, KOLKATA'
);

INSERT INTO "CLAIM"."POLICY"
VALUES (
  1, 
  'PREMIUM GOLD', 
  'B1', 
  'FAMILY COVERAGE', 
  5000, 
  2, 
  500000
);
INSERT INTO "CLAIM"."POLICY"
VALUES (
  2, 
  'PREMIUM SILVER', 
  'B2', 
  'CORPORATE DISCOUNT', 
  8000, 
  1, 
  300000
);

INSERT INTO "CLAIM"."MEMBER_POLICY"
VALUES (
  1011, 
  '101', 
  '1', 
  '2019-05-01', 
  '2021-01-01', 
  1000, 
  FALSE, 
  '2021-05-01'
);
INSERT INTO "CLAIM"."MEMBER_POLICY"
VALUES (
  1012, 
  '101', 
  '2', 
  '2020-01-01', 
  '2020-12-01', 
  0, 
  FALSE, 
  '2021-01-01'
);
INSERT INTO "CLAIM"."MEMBER_POLICY"
VALUES (
  1022, 
  '102', 
  '1', 
  '2020-01-01', 
  '2021-04-01', 
  2000, 
  FALSE, 
  '2022-01-01'
);

INSERT INTO "CLAIM"."MEMBER_PREMIUM"
VALUES (
  1011, 
  '101', 
  '1', 
  '2021-01-01', 
  1000
);
INSERT INTO "CLAIM"."MEMBER_PREMIUM"
VALUES (
  1012, 
  '101', 
  '2', 
  '2020-12-01', 
  0
);
INSERT INTO "CLAIM"."MEMBER_PREMIUM"
VALUES (
  1022, 
  '102', 
  '1', 
  '2021-04-01', 
  2000
);

INSERT INTO "CLAIM"."MEMBER_BENEFIT"
VALUES (
  1011, 
  '101', 
  '1', 
  'B1', 
  'FAMILY COVERAGE', 
  500000
);
INSERT INTO "CLAIM"."MEMBER_BENEFIT"
VALUES (
  1012, 
  '101', 
  '2', 
  'B2', 
  'CORPORATE DISCOUNT', 
  300000
);
INSERT INTO "CLAIM"."MEMBER_BENEFIT"
VALUES (
  1022, 
  '102', 
  '1', 
  'B1', 
  'FAMILY COVERAGE', 
  500000
);

INSERT INTO "CLAIM"."PROVIDER_POLICY"
VALUES (
  9001, 
  'TATA', 
  '1', 
  'PREMIUM GOLD', 
  'H002', 
  'TATA CANCER CENTRE', 
  'KOLKATA', 
  'B1', 
  'FAMILY COVERAGE', 
  5000, 
  2, 
  500000
);
INSERT INTO "CLAIM"."PROVIDER_POLICY"
VALUES (
  9002, 
  'RELIANCE', 
  '2', 
  'PREMIUM SILVER', 
  'H001', 
  'APOLLO GLENEAGLES', 
  'DELHI', 
  'B2', 
  'CORPORATE DISCOUNT', 
  8000, 
  1, 
  300000
);
INSERT INTO "CLAIM"."PROVIDER_POLICY"
VALUES (
  9003, 
  'STAR ALLIANCE', 
  '1', 
  'PREMIUM GOLD', 
  'H003', 
  'BHAGIRATHI NEOTIA', 
  'MUMBAI', 
  'B1', 
  'FAMILY COVERAGE', 
  5000, 
  2, 
  500000
);
