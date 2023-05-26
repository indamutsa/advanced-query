This is a [Next.js](https://nextjs.org/) project bootstrapped with [`create-next-app`](https://github.com/vercel/next.js/tree/canary/packages/create-next-app).

## Getting Started

First, run the development server:

```bash
npm run dev
# or
yarn dev
```

Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

You can start editing the page by modifying `pages/index.js`. The page auto-updates as you edit the file.

[API routes](https://nextjs.org/docs/api-routes/introduction) can be accessed on [http://localhost:3000/api/hello](http://localhost:3000/api/hello). This endpoint can be edited in `pages/api/hello.js`.

The `pages/api` directory is mapped to `/api/*`. Files in this directory are treated as [API routes](https://nextjs.org/docs/api-routes/introduction) instead of React pages.

## Learn More

To learn more about Next.js, take a look at the following resources:

- [Next.js Documentation](https://nextjs.org/docs) - learn about Next.js features and API.
- [Learn Next.js](https://nextjs.org/learn) - an interactive Next.js tutorial.

You can check out [the Next.js GitHub repository](https://github.com/vercel/next.js/) - your feedback and contributions are welcome!

## Deploy on Vercel

The easiest way to deploy your Next.js app is to use the [Vercel Platform](https://vercel.com/new?utm_medium=default-template&filter=next.js&utm_source=create-next-app&utm_campaign=create-next-app-readme) from the creators of Next.js.

Check out our [Next.js deployment documentation](https://nextjs.org/docs/deployment) for more details.


etl transformation: http://178.238.238.209:8085/mms/api-docs/transform
etl query: http://178.238.238.209:8087/mms/api-docs/query
etl metrics: http://178.238.238.209:8186/mms/api-docs/metrics
etl validate: http://178.238.238.209:8086/mms/api-docs/validate
api http://178.238.238.209:3200/store/api-docs/


ACCEPT     tcp  --  anywhere             172.20.0.2           tcp dpt:9300
ACCEPT     tcp  --  anywhere             172.20.0.2           tcp dpt:9200
ACCEPT     tcp  --  anywhere             172.20.0.3           tcp dpt:27017
ACCEPT     tcp  --  anywhere             172.20.0.4           tcp dpt:8186
ACCEPT     tcp  --  anywhere             172.20.0.6           tcp dpt:27017
ACCEPT     tcp  --  anywhere             172.20.0.7           tcp dpt:27017
ACCEPT     tcp  --  anywhere             172.20.0.8           tcp dpt:27017
ACCEPT     tcp  --  anywhere             172.20.0.10          tcp dpt:8086
ACCEPT     tcp  --  anywhere             172.20.0.12          tcp dpt:3500
ACCEPT     tcp  --  anywhere             172.20.0.13          tcp dpt:27017
ACCEPT     tcp  --  anywhere             172.20.0.14          tcp dpt:1234
ACCEPT     tcp  --  anywhere             172.20.0.15          tcp dpt:27017
ACCEPT     tcp  --  anywhere             172.20.0.17          tcp dpt:8085
ACCEPT     tcp  --  anywhere             172.20.0.18          tcp dpt:8087
ACCEPT     tcp  --  anywhere             172.20.0.19          tcp dpt:9600
ACCEPT     tcp  --  anywhere             172.20.0.19          tcp dpt:5044
ACCEPT     tcp  --  anywhere             172.20.0.20          tcp dpt:5601
ACCEPT     tcp  --  anywhere             172.20.0.21          tcp dpt:27017
ACCEPT     tcp  --  anywhere             172.20.0.22          tcp dpt:27017
ACCEPT     tcp  --  anywhere             172.20.0.19          tcp dpt:5000
ACCEPT     udp  --  anywhere             172.20.0.19          udp dpt:5000
ACCEPT     tcp  --  anywhere             172.20.0.25          tcp dpt:3300
ACCEPT     tcp  --  anywhere             172.20.0.26          tcp dpt:3200

elastic api: https://178.238.238.209.sslip.io/repo/elastic/mdeforge.metamodels/_search
kibana: https://178.238.238.209.sslip.io/



connect to mongo: mongodb://178.238.238.209:27018/db?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false