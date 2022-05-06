const path = require("path");

const nextConfig = {
  reactStrictMode: true,
  async rewrites() {
    return [
      {
        source: "/model-service",
        destination: "/model_service",
      },
      {
        source: "/advanced-search",
        destination: "/advanced_search",
      },
      {
        source: "/artifact-display",
        destination: "/ModelDisplay",
      },
      {
        source: "/edit-model",
        destination: "/ModelEdit",
      },
    ];
  },
  sassOptions: {
    includePaths: [path.join(__dirname, "styles")],
    prependData: `@import "variables.scss";`,
  },
  compiler: {
    // ssr and displayName are configured by default
    styledComponents: true,
  },
};

module.exports = nextConfig;
