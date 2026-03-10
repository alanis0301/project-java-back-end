--
-- PostgreSQL database dump
--

\restrict 0Qm6a8G2bNHVdGbKbFxrHNTYH8dVuMQHUyEEW78e95f2WnphzHgkHb9d0BZVda5

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.1

-- Started on 2026-03-06 10:01:09

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 17013)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 5041 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS '';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 222 (class 1259 OID 17026)
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    id_line integer
);


ALTER TABLE public.category OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 17025)
-- Name: category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.category_id_seq OWNER TO postgres;

--
-- TOC entry 5043 (class 0 OID 0)
-- Dependencies: 221
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.category_id_seq OWNED BY public.category.id;


--
-- TOC entry 220 (class 1259 OID 17015)
-- Name: line; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.line (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE public.line OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 17014)
-- Name: line_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.line_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.line_id_seq OWNER TO postgres;

--
-- TOC entry 5044 (class 0 OID 0)
-- Dependencies: 219
-- Name: line_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.line_id_seq OWNED BY public.line.id;


--
-- TOC entry 224 (class 1259 OID 17042)
-- Name: model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.model (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    id_category integer
);


ALTER TABLE public.model OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 17041)
-- Name: model_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.model_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.model_id_seq OWNER TO postgres;

--
-- TOC entry 5045 (class 0 OID 0)
-- Dependencies: 223
-- Name: model_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.model_id_seq OWNED BY public.model.id;


--
-- TOC entry 4867 (class 2604 OID 17029)
-- Name: category id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category ALTER COLUMN id SET DEFAULT nextval('public.category_id_seq'::regclass);


--
-- TOC entry 4866 (class 2604 OID 17018)
-- Name: line id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.line ALTER COLUMN id SET DEFAULT nextval('public.line_id_seq'::regclass);


--
-- TOC entry 4868 (class 2604 OID 17045)
-- Name: model id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model ALTER COLUMN id SET DEFAULT nextval('public.model_id_seq'::regclass);


--
-- TOC entry 5033 (class 0 OID 17026)
-- Dependencies: 222
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (id, name, id_line) FROM stdin;
1	Cronos Old	1
2	Cronos L	1
3	Cronos NG	1
4	Ares TB	2
5	Ares THS	2
\.


--
-- TOC entry 5031 (class 0 OID 17015)
-- Dependencies: 220
-- Data for Name: line; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.line (id, name) FROM stdin;
1	Cronos
2	Ares
\.


--
-- TOC entry 5035 (class 0 OID 17042)
-- Dependencies: 224
-- Data for Name: model; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.model (id, name, id_category) FROM stdin;
1	Cronos 6001-A	1
2	Cronos 6003	1
3	Cronos 7023	1
4	Cronos 6021L	2
5	Cronos 7023L	2
6	Cronos 6001-NG	3
7	Cronos 6003-NG	3
8	Cronos 6021-NG	3
9	Cronos 6031-NG	3
10	Cronos 7021-NG	3
11	Cronos 7023-NG	3
12	Ares 7021	4
13	Ares 7031	4
14	Ares 7023	4
15	Ares 8023 15	5
16	Ares 8023 200	5
17	Ares 8023 2,5	5
\.


--
-- TOC entry 5046 (class 0 OID 0)
-- Dependencies: 221
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.category_id_seq', 50, true);


--
-- TOC entry 5047 (class 0 OID 0)
-- Dependencies: 219
-- Name: line_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.line_id_seq', 20, true);


--
-- TOC entry 5048 (class 0 OID 0)
-- Dependencies: 223
-- Name: model_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.model_id_seq', 170, true);


--
-- TOC entry 4874 (class 2606 OID 17035)
-- Name: category category_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_name_key UNIQUE (name);


--
-- TOC entry 4876 (class 2606 OID 17033)
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- TOC entry 4870 (class 2606 OID 17024)
-- Name: line line_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.line
    ADD CONSTRAINT line_name_key UNIQUE (name);


--
-- TOC entry 4872 (class 2606 OID 17022)
-- Name: line line_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.line
    ADD CONSTRAINT line_pkey PRIMARY KEY (id);


--
-- TOC entry 4878 (class 2606 OID 17051)
-- Name: model model_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT model_name_key UNIQUE (name);


--
-- TOC entry 4880 (class 2606 OID 17049)
-- Name: model model_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT model_pkey PRIMARY KEY (id);


--
-- TOC entry 4881 (class 2606 OID 17036)
-- Name: category category_id_line_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_id_line_fkey FOREIGN KEY (id_line) REFERENCES public.line(id);


--
-- TOC entry 4882 (class 2606 OID 17052)
-- Name: model model_id_category_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT model_id_category_fkey FOREIGN KEY (id_category) REFERENCES public.category(id);


--
-- TOC entry 5042 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2026-03-06 10:01:09

--
-- PostgreSQL database dump complete
--

\unrestrict 0Qm6a8G2bNHVdGbKbFxrHNTYH8dVuMQHUyEEW78e95f2WnphzHgkHb9d0BZVda5

